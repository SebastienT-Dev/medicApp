package fr.move.in.med.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.move.in.med.model.Professionnel;
import fr.move.in.med.vo.ProfessionnelVo;

/**
 * 
 * @author sebastienternisien
 * @since 27/09/2019
 * 
 *        Classe DAO pour les professionnels permettant d'effectuer les requetes
 *        en base de données pour les fonctionnalités liées aux professionnels
 */
@Repository
public class ProfessionnelDao extends MainDao {

	/**
	 * 
	 * @return
	 */
	public List<Object> retreiveAllProfessionnels() {
		return this.getAllPatientOrPro(Professionnel.class);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProfessionnelVo findPatientById(long id) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(String.format("from Professionnel as p where p.idPro = %s", id));
		Object proFromDao = (Object) q.getSingleResult();
		ProfessionnelVo monPro = (ProfessionnelVo) this.mapper.convertObject(proFromDao, ProfessionnelVo.class);
		return monPro;
	}
}
