package fr.move.in.med.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.dozer.MappingException;
import org.hibernate.Session;
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
	protected List<Object> getAllPatientOrPro(Class<?> clazzRequest, Class<?> clazzResult) {
		if (clazzRequest == null) {
			return new ArrayList<Object>();
		}

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(String.format("from %s as o", clazzRequest.getName()));
		List<Object> listResult = q.getResultList();
		List<Object> listPatientOrPro = mapper.convertListObject(listResult, clazzResult);

		return listPatientOrPro;
	}

	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public Boolean createPatientOrPro(Object patientOrPro, Class<?> destinationClass) {
		Boolean isInsert = false;

		try {
			Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
			EntityManager em = emf.createEntityManager();
			Transaction transac = (Transaction) em.getTransaction();
			transac.begin();
			em.unwrap(Session.class).save(patientOrProDao);
			em.flush();
			transac.commit();
		} catch (MappingException e) {
			// TODO: handle exception
		} catch (IllegalStateException e) {
			// TODO: handle exception
		} catch (PersistenceException e) {
			// TODO: handle exception
		}

		isInsert = true;

		return isInsert;
	}

	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public Boolean deletePatientOrPro(Object patientOrPro, Class<?> destinationClass) {
		Boolean isDelete = false;

		try {
			Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
			EntityManager em = emf.createEntityManager();
			Transaction transac = (Transaction) em.getTransaction();
			transac.begin();
			// TODO Gérer l'entity manager pour le fermer à chaque requete et eviter le
			// merge pour le delete
			em.remove(em.merge(patientOrProDao));
			em.flush();
			transac.commit();
		} catch (MappingException e) {
			// TODO: handle exception
		} catch (IllegalStateException e) {
			// TODO: handle exception
		} catch (PersistenceException e) {
			// TODO: handle exception
		}

		isDelete = true;

		return isDelete;
	}

	/**
	 * 
	 * @param patientOrPro
	 */
	@Transactional
	public Boolean updatePatientOrPro(Object patientOrPro, Class<?> destinationClass) {
		Boolean isUpdate = false;

		try {
			Object patientOrProDao = mapper.convertObject(patientOrPro, destinationClass);
			EntityManager em = emf.createEntityManager();
			Transaction transac = (Transaction) em.getTransaction();
			transac.begin();
			em.merge(patientOrProDao);
			em.flush();
			transac.commit();

		} catch (MappingException e) {
			// TODO: handle exception
		} catch (IllegalStateException e) {
			// TODO: handle exception
		} catch (PersistenceException e) {
			// TODO: handle exception
		}

		isUpdate = true;

		return isUpdate;
	}
}
