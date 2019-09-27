package fr.move.in.med.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.move.in.med.model.Patient;
import fr.move.in.med.vo.PatientVo;

/**
 * 
 * @author sebastienternisien
 * @since 27/09/2019
 * 
 *        Classe DAO pour les patients permettant d'effectuer les requetes en
 *        base de données pour les fonctionnalités liées aux patients
 */
@Repository
public class PatientDao extends MainDao {

	public List<Object> retreiveAllPatients() {
		return this.getAllPatientOrPro(Patient.class);
	}

	public PatientVo findPatientById(long id) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(String.format("from Patient as p where p.idPatient = %s", id));
		Object patientFromDao = q.getSingleResult();
		PatientVo monPatient = (PatientVo) this.mapper.convertObject(patientFromDao, PatientVo.class);
		return monPatient;
	}

}
