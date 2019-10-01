package fr.move.in.med.controllers;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.move.in.med.exceptions.CustomException;
import fr.move.in.med.services.PatientService;
import fr.move.in.med.services.ProfessionnelService;
import fr.move.in.med.status.RestApiSuccess;
import fr.move.in.med.vo.PatientVo;
import fr.move.in.med.vo.ProfessionnelVo;
import fr.move.in.med.vo.WrapperRecherchePatient;
import fr.move.in.med.vo.WrapperRecherchePro;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe servant de controller pour capturer les requetes envoyer à
 *        l'API
 */
@RestController
@RequestMapping(value = "/medicApp")
public class ApiController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private ProfessionnelService professionnelService;

	/**
	 * Requete permettant d'effectuer une recherche de patients à partir de critère
	 * utilisateur
	 * 
	 * @param maRecherche
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@RequestMapping(value = "/find/patients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findPatientByCriterias(@RequestBody @Valid WrapperRecherchePatient maRecherche)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		StringBuilder str = new StringBuilder();
		return new ResponseEntity<List<?>>(patientService.getPatientOrProByCriterias(maRecherche.getFindPatient(),
				maRecherche.getTypeDeTri(), str, true, "p"), HttpStatus.OK);
	}

	/**
	 * Requete permettant d'effectuer une recherche de patients à partir de critère
	 * utilisateur
	 * 
	 * @param maRecherche
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@RequestMapping(value = "/find/pros", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findProByCriterias(@RequestBody @Valid WrapperRecherchePro maRecherche)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		StringBuilder str = new StringBuilder();
		return new ResponseEntity<List<?>>(professionnelService.getPatientOrProByCriterias(maRecherche.getFindPro(),
				maRecherche.getTypeDeTri(), str, true, "p"), HttpStatus.OK);
	}

	/**
	 * Requete permettant de retourner l'intégralité des patients en base de données
	 * et de retourner cette liste au format JSON
	 * 
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/all/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAllPatients() throws CustomException {
		return new ResponseEntity<List<Object>>(patientService.getAllPatient(), HttpStatus.OK);
	}

	@RequestMapping(value = "/patient/pro/{patientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getListProfessionnelFromPatient(@PathVariable(name = "patientId") int id)
			throws CustomException {
		return new ResponseEntity<List<Object>>(patientService.getProFromPatient(id), HttpStatus.OK);
	}

	/**
	 * Requete permettant de créer un patient en base de données
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping(value = "/create/patient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> createPatient(@Valid @RequestBody PatientVo patient) {
		patientService.createNewPatient(patient);

		return new ResponseEntity<>(
				new RestApiSuccess(HttpStatus.CREATED.toString(), "Le nouveau patient a été créer avec succés"),
				HttpStatus.CREATED);
	}

	/**
	 * Requete permettant de mettre à jour les informations d'un patient en base de
	 * données
	 * 
	 * @param id
	 * @param patient
	 * @throws CustomException
	 */
	@RequestMapping(value = "/update/patient/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> updatePatient(@PathVariable(name = "id") int id,
			@Valid @RequestBody PatientVo patient) throws CustomException {
		patientService.updatePatient(patient, id);

		return new ResponseEntity<>(
				new RestApiSuccess(HttpStatus.NO_CONTENT.toString(), "Le patient a été mis à jour avec succés"),
				HttpStatus.NO_CONTENT);
	}

	/**
	 * Requete permettant de supprimer un patient en base de données
	 * 
	 * @param id
	 * @throws CustomException
	 */
	@RequestMapping(value = "/delete/patient/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> deletePatientById(@PathVariable(name = "id") long id) throws CustomException {
		patientService.deletePatient(id);

		return new ResponseEntity<>(
				new RestApiSuccess(HttpStatus.OK.toString(), "Le patient a été supprimé avec succés"), HttpStatus.OK);

	}

	/**
	 * Requete permettant de retourner l'intégralité des professionnels en base de
	 * données et de retourner cette liste au format JSON
	 * 
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/all/professionnels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAllProfessionnels() throws CustomException {
		List<Object> professionnels = professionnelService.getAllProfessionnel();
		return new ResponseEntity<List<Object>>(professionnels, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/pro/patient/{proId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getListPatientFromPro(@PathVariable(name = "proId") int id) throws CustomException {
		return new ResponseEntity<List<Object>>(professionnelService.getPatientsFromPro(id), HttpStatus.OK);
	}

	/**
	 * Requete permettant de créer un professionnel en base de données
	 * 
	 * @param patient
	 */
	@RequestMapping(value = "/create/professionnel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createProfessionnel(@Valid @RequestBody ProfessionnelVo pro) {
		professionnelService.createNewProfessionnel(pro);

		return new ResponseEntity<>(
				new RestApiSuccess(HttpStatus.CREATED.toString(), "Le nouveau professionnel a été créer avec succés"),
				HttpStatus.CREATED);

	}

	/**
	 * Requete permettant de mettre à jour les informations d'un professionnel en
	 * base de données
	 * 
	 * @param id
	 * @param patient
	 * @throws CustomException
	 */
	@RequestMapping(value = "/update/professionnel/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> updateProfessionnel(@PathVariable(name = "id") int id, @RequestBody ProfessionnelVo pro)
			throws CustomException {
		professionnelService.updateProfessionnel(pro, id);

		return new ResponseEntity<>(
				new RestApiSuccess(HttpStatus.NO_CONTENT.toString(), "Le professionnel a été mis à jour avec succés"),
				HttpStatus.NO_CONTENT);
	}

	/**
	 * Requete permettant de supprimer un patient en base de données
	 * 
	 * @param id
	 * @throws CustomException
	 */
	@RequestMapping(value = "/delete/professionnel/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> deleteProfessionnelById(@PathVariable(name = "id") long id) throws CustomException {
		professionnelService.deleteProfessionnel(id);

		return new ResponseEntity<>(
				new RestApiSuccess(HttpStatus.OK.toString(), "Le professionnel a été supprimé avec succés") , HttpStatus.OK);
	}
}
