package fr.move.in.med.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.ProfessionnelDao;
import fr.move.in.med.exceptions.CustomException;
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.utils.MapperUtils;
import fr.move.in.med.vo.PatientBasicDetails;
import fr.move.in.med.vo.PatientVo;
import fr.move.in.med.vo.ProfessionnelVo;

@Service
public class ProfessionnelService extends MainService {

	@Autowired
	private ProfessionnelDao professionnelDao;

	@Autowired
	protected MapperUtils mapper;

	/**
	 * Fonction permettant de récupérer l'ensemble des patients en bdd
	 * 
	 * @return {@link ArrayList} retourne une liste d'objet {@link ProfessionnelVo}
	 */
	public List<Object> getAllProfessionnel() {
		return professionnelDao.retreiveAllProfessionnels();
	}

	/**
	 * Fonction permettant de récuperer les patients d'un professionnel
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getPatientsFromPro(int id) {
		ProfessionnelVo monPro = professionnelDao.findProfessionnelById(id);
		Set<PatientVo> set = monPro.getListPatients();
		List<Object> listPro = mapper.convertListObject(set.stream().collect(Collectors.toList()),
				PatientBasicDetails.class);

		return listPro;

	}

	/**
	 * Procédure permettant de créer un nouveau professionnel
	 * 
	 * @param monPro
	 */
	public void createNewProfessionnel(ProfessionnelVo monPro) {
		professionnelDao.createPatientOrPro(monPro, Professionnel.class);
	}

	/**
	 * Procédure permettant de mettre à jour un professionnel
	 * 
	 * @param monPro
	 * @param id
	 * @throws CustomException
	 */
	public void updateProfessionnel(ProfessionnelVo monPro, int id) throws CustomException {
		if (professionnelDao.findProfessionnelById(id) == null) {
			throw new CustomException("Utilsateur non trouvé", HttpStatus.NOT_FOUND.toString());
		}

		professionnelDao.updatePatientOrPro(monPro, Professionnel.class, id);
	}

	/**
	 * Procédure permettant de supprimer un professionnel
	 * 
	 * @param id
	 * @throws CustomException
	 */
	public void deleteProfessionnel(long id) throws CustomException {

		ProfessionnelVo monPro = professionnelDao.findProfessionnelById(id);
		professionnelDao.deletePatientOrPro(monPro, Professionnel.class);
	}
}
