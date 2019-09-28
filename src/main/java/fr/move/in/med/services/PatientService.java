package fr.move.in.med.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.PatientDao;
import fr.move.in.med.model.Patient;
import fr.move.in.med.vo.PatientVo;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	/**
	 * Fonction permettant de récupérer l'ensemble des patients en bdd
	 * 
	 * @return {@link ArrayList} retourne une liste d'objet {@link PatientVo}
	 */
	public List<Object> getAllPatient() {
		List<Object> listPatients = patientDao.retreiveAllPatients();
		
		if (CollectionUtils.isEmpty(listPatients)) {
			
		}
		return listPatients;
	}

	/**
	 * 
	 * @param monPatient
	 * @return
	 */
	public void createNewPatient(PatientVo monPatient) {
		patientDao.createPatientOrPro(monPatient, Patient.class);
	}

	/**
	 * 
	 * @param monPatient
	 * @param id
	 * @return
	 */
	public void updatePatient(PatientVo monPatient, long id) {
		if (patientDao.findPatientById(id) == null) {

		}

		patientDao.updatePatientOrPro(monPatient, Patient.class);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public void deletePatient(long id) {
		PatientVo p = patientDao.findPatientById(id);

		if (p == null) {

		}

		patientDao.deletePatientOrPro(p, Patient.class);

	}
}
