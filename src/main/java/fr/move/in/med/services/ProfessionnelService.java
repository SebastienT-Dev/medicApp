package fr.move.in.med.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.ProfessionnelDao;
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.vo.ProfessionnelVo;

@Service
public class ProfessionnelService {
	
	@Autowired
	private ProfessionnelDao professionnelDao;
	
	/**
	 * Fonction permettant de récupérer l'ensemble des patients en bdd
	 * 
	 * @return {@link ArrayList} retourne une liste d'objet {@link ProfessionnelVo}
	 */
	public List<Object> getAllProfessionnel() {	
		return professionnelDao.retreiveAllProfessionnels();
	}
	
	public void createNewProfessionnel(ProfessionnelVo monPro) {
		professionnelDao.createPatientOrPro(monPro, Professionnel.class);
	}
	
	public void updateProfessionnel(ProfessionnelVo monPro) {
		professionnelDao.updatePatientOrPro(monPro, Professionnel.class);
	}
	
	public void deleteProfessionnel(ProfessionnelVo monPro) {
		professionnelDao.deletePatientOrPro(monPro, Professionnel.class);
	}
}
