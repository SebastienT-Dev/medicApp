package fr.move.in.med.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.PatientDao;
import fr.move.in.med.exceptions.CustomException;
import fr.move.in.med.model.Patient;
import fr.move.in.med.utils.MapperUtils;
import fr.move.in.med.vo.PatientVo;
import fr.move.in.med.vo.ProfessionnelBasicDetails;
import fr.move.in.med.vo.ProfessionnelVo;

@Service
public class PatientService extends MainService {

	@Autowired
	private PatientDao patientDao;

	@Autowired
	protected MapperUtils mapper;

	/**
	 * Fonction permettant de récupérer l'intégralité des patients
	 * 
	 * @return {@link ArrayList} retourne une liste d'objet {@link PatientVo}
	 * @throws CustomException 
	 */
	public List<Object> getAllPatient() throws CustomException {
		List<Object> listPatients = patientDao.retreiveAllPatients();

		if (CollectionUtils.isEmpty(listPatients)) {
			throw new CustomException("Aucun patient existant", HttpStatus.NO_CONTENT.toString());
		}
		
		return listPatients;
	}

	/**
	 * Fonction permettant de récupérer les professionnels d'un patient
	 * 
	 * @param id
	 * @return
	 * @throws CustomException 
	 */
	public List<Object> getProFromPatient(int id) throws CustomException {
		PatientVo monPatient = patientDao.findPatientById(id);
		
		if (monPatient == null) {
			throw new CustomException("Aucun patient existant avec ID", HttpStatus.NO_CONTENT.toString());
		}
		
		Set<ProfessionnelVo> set = monPatient.getListProfessionnel();

		List<Object> listPro = mapper.convertListObject(set.stream().collect(Collectors.toList()),
				ProfessionnelBasicDetails.class);

		return listPro;

	}

	/**
	 * Procédure permettant de créer un nouveau patient
	 * 
	 * @param monPatient - le patient a créé
	 */
	public void createNewPatient(PatientVo monPatient) {
		patientDao.createPatientOrPro(monPatient, Patient.class);
	}

	/**
	 * Procédure permerttant de mettre à jour un patient
	 * 
	 * @param monPatient
	 * @param id
	 * @throws CustomException 
	 */
	public void updatePatient(PatientVo monPatient, int id) throws CustomException {
		patientDao.findPatientById(id);
		
		if (patientDao.findPatientById(id) == null) {
			throw new CustomException("Aucun patient existant avec ID", HttpStatus.NO_CONTENT.toString());
		}
		
		patientDao.updatePatientOrPro(monPatient, Patient.class, id);
	}

	/**
	 * 
	 * Procédure permettant de supprimer un patient
	 * 
	 * @param id
	 * @return
	 * @throws CustomException 
	 */
	public void deletePatient(long id) throws CustomException {
		PatientVo p = patientDao.findPatientById(id);

		if (p == null) {
			throw new CustomException("Aucun patient existant avec ID", HttpStatus.NO_CONTENT.toString());
		}

		patientDao.deletePatientOrPro(p, Patient.class);

	}
}
