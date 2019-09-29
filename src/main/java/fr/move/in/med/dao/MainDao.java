package fr.move.in.med.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.move.in.med.model.Patient;
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.utils.MapperUtils;
import fr.move.in.med.vo.PatientVo;

/**
 * 
 * Classe DAO principal regroupant les différentes hql pouvant etre communes
 * 
 * @author sebastienternisien
 *
 */
public abstract class MainDao {

	@Autowired
	protected EntityManagerFactory emf;

	@Autowired
	protected MapperUtils mapper;

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * 
	 * @param clazzRequest
	 * @param clazzResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<Object> getAllObject(Class<?> clazzRequest, Class<?> clazzResult) {
		if (clazzRequest == null || clazzResult == null) {
			return new ArrayList<Object>();
		}

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(String.format("from %s as o", clazzRequest.getName()));
		List<Object> listResult = q.getResultList();
		List<Object> listObject = mapper.convertListObject(listResult, clazzResult);

		return listObject;
	}

	/**
	 * 
	 * @param patientOrPro
	 * @param destinationClass
	 */
	@Transactional
	public void createPatientOrPro(Object patientOrPro, Class<?> destinationClass) {

		Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
		EntityManager em = emf.createEntityManager();
		Transaction transac = (Transaction) em.getTransaction();
		transac.begin();
		em.unwrap(Session.class).save(patientOrProDao);

	}

	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public void deletePatientOrPro(Object patientOrPro, Class<?> destinationClass) {

		Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
		EntityManager em = emf.createEntityManager();
		Transaction transac = (Transaction) em.getTransaction();
		transac.begin();
		// TODO Gérer l'entity manager pour le fermer à chaque requete et eviter le
		// merge pour le delete
		em.remove(em.merge(patientOrProDao));
		em.flush();
		transac.commit();

	}

	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public void updatePatientOrPro(Object patientOrPro, Class<?> destinationClass, int id) {

		if (patientOrPro instanceof PatientVo) {
			Patient patientOrProDao = (Patient) mapper.convertObject(patientOrPro, destinationClass);
			patientOrProDao.setIdPatient(id);
			EntityManager em = emf.createEntityManager();
			Transaction transac = (Transaction) em.getTransaction();
			transac.begin();
			em.merge(patientOrProDao);
			em.flush();
			transac.commit();
		} else {

			Professionnel patientOrProDao = (Professionnel) mapper.convertObject(patientOrPro, destinationClass);
			patientOrProDao.setIdPro(id);
			EntityManager em = emf.createEntityManager();
			Transaction transac = (Transaction) em.getTransaction();
			transac.begin();
			em.merge(patientOrProDao);
			em.flush();
			transac.commit();
		}

	}

}
