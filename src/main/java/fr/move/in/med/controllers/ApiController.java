package fr.move.in.med.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
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
import fr.move.in.med.status.RestApiError;
import fr.move.in.med.status.RestApiSuccess;
import fr.move.in.med.vo.PatientVo;
import fr.move.in.med.vo.ProfessionnelVo;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe servant de controller pour capturer les requetes envoyer à l'API
 */
@RestController
@RequestMapping(value = "/medicApp")
public class ApiController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ProfessionnelService professionnelService;
	
	
	/**
	 * Requete permettant de retourner l'intégralité des patients en base de données et de retourner cette liste
	 * au format JSON
	 * 
	 * @return
	 */
	@RequestMapping(value = "/all/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllPatients() {
        return new ResponseEntity<List<Object>>(patientService.getAllPatient(), HttpStatus.OK);
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
        
		return new ResponseEntity<>(new RestApiSuccess(HttpStatus.CREATED.toString(), "Le nouveau patient a été créer avec succés"), HttpStatus.CREATED);
    }
	
	/**
	 * Requete permettant de mettre à jour les informations d'un patient en base de données
	 * 
	 * @param id
	 * @param patient
	 */
	@RequestMapping(value = "/update/patient/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updatePatient(@PathVariable(name = "id") int id, @Valid @RequestBody PatientVo patient) {
        
        patientService.updatePatient(patient, id);
    }
	
	/**
	 * Requete permettant de supprimer un patient en base de données
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/delete/patient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deletePatientById(@PathVariable(name = "id") long id) {
        
        patientService.deletePatient(id);
    }
	
	/**
	 * Requete permettant de retourner l'intégralité des professionnels en base de données et de retourner cette liste
	 * au format JSON
	 * 
	 * @return
	 */
	@RequestMapping(value = "/all/professionnels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllProfessionnels() {
        List<Object> professionnels = professionnelService.getAllProfessionnel();
        if (CollectionUtils.isEmpty(professionnels)) {
            return new ResponseEntity<RestApiError>(new RestApiError("No Content", "pas de contenu à afficher"), HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
  
        return new ResponseEntity<List<Object>>(professionnels, HttpStatus.OK);
    }

	/**
	 * Requete permettant de créer un professionnel en base de données
	 * 
	 * @param patient
	 */
	@RequestMapping(value = "/create/professionnel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createProfessionnel(@Valid @RequestBody ProfessionnelVo pro) {
        professionnelService.createNewProfessionnel(pro);
        
    }
	
	/**
	 * Requete permettant de mettre à jour les informations d'un professionnel en base de données
	 * 
	 * @param id
	 * @param patient
	 * @throws CustomException 
	 */
	@RequestMapping(value = "/update/professionnel/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateProfessionnel(@PathVariable(name = "id") int id, @RequestBody ProfessionnelVo pro) throws CustomException {
        professionnelService.updateProfessionnel(pro, id);
    }
	
	/**
	 * Requete permettant de supprimer un patient en base de données
	 * 
	 * @param id
	 * @throws CustomException 
	 */
	@RequestMapping(value = "/delete/professionnel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteProfessionnelById(@PathVariable(name = "id") long id) throws CustomException {
        professionnelService.deleteProfessionnel(id);
    }
}
