package fr.move.in.med.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.move.in.med.model.DomainePro;
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.vo.DomaineProVo;
import fr.move.in.med.vo.ProfessionnelBasicDetails;
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
	 * Fonction permettant de récupérer une collection de professionnels
	 * 
	 * @return
	 */
	public List<Object> retreiveAllProfessionnels() {
		return this.getAllObject(Professionnel.class, ProfessionnelBasicDetails.class);
	}
	
	/**
	 * Fonction permettant de récupérer une collection de domaine professionnel
	 * 
	 * @return
	 */
	public List<Object> retreiveAllDomainePro(){
		return this.getAllObject(DomainePro.class, DomaineProVo.class);
	}
	
	/**
	 * Fonction permettant de récuper un professionnel à partir de critère de recherche
	 * 
	 * @param query
	 * @return
	 */
	public List<Object> findProByCriteria(String query){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(query);
		@SuppressWarnings("unchecked")
		List<Object> listResult = (List<Object>) q.getResultList();
		List<Object> listPro = this.mapper.convertListObject(listResult, ProfessionnelBasicDetails.class);
			
		return listPro;
	}
	
	/**
	 * Fonction permettant de rechercher un professionnel à partir de son id
	 * 
	 * @param id
	 * @return
	 */
	public ProfessionnelVo findProfessionnelById(long id) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(String.format("from Professionnel as p where p.idPro = %s", id));
		Professionnel proFromDao = (Professionnel) q.getSingleResult();
		ProfessionnelVo monPro = (ProfessionnelVo) this.mapper.convertObject(proFromDao, ProfessionnelVo.class);
		return monPro;
	}
}
