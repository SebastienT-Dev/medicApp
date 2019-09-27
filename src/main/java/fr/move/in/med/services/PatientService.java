package fr.move.in.med.services;

import java.util.ArrayList;
import java.util.List;

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
		return patientDao.retreiveAllPatients();
	}
	
	public void createNewPatient(PatientVo monPatient) {
		patientDao.createPatientOrPro(monPatient, Patient.class);
	}
}
