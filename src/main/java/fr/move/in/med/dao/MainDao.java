package fr.move.in.med.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.move.in.med.utils.MapperUtils;

public abstract class MainDao {

	@Autowired
	protected EntityManagerFactory emf;

	@Autowired
	protected MapperUtils mapper;

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * Fonction permettant d'effectuer une requete en base de données pour récupérer
	 * une liste de patients ou une liste de professionnels
	 * 
	 * @param clazz - la class de l'objet concerné
	 * 
	 * @return {@link ArrayList} une liste d'objets contenant soit des patients ou
	 *         des pro
	 */
	@SuppressWarnings("unchecked")
	protected List<Object> getAllPatientOrPro(Class<?> clazz) {
		if (clazz == null) {
			return new ArrayList<Object>();
		}

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(String.format("from %s as o", clazz.getName()));
		List<Object> listResult = q.getResultList();
		List<Object> listPatientOrPro = mapper.convertListObject(listResult, clazz);

		return listPatientOrPro;
	}
	
	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public void createPatientOrPro(Object patientOrPro, Class<?> destinationClass) {
		Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
		EntityManager em = emf.createEntityManager();
		Transaction transac = (Transaction) em.getTransaction();
		transac.begin();
		em.persist(patientOrProDao);
		em.flush();
		transac.commit();
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
		em.flush();
		em.remove(patientOrProDao);
		transac.commit();
		
	}
	
	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public void updatePatientOrPro(Object patientOrPro, Class<?> destinationClass) {
		Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
		EntityManager em = emf.createEntityManager();
		Transaction transac = (Transaction) em.getTransaction();
		transac.begin();
		em.merge(patientOrProDao);
		em.flush();
		transac.commit();
	}
}
