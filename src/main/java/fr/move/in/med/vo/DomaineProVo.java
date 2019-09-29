package fr.move.in.med.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.dozer.Mapping;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "domaine_pro"
 * 
 */
public class DomaineProVo {
	
	@Mapping(value = "idDomainePro")
	@Min(value = 1, message = "la valeur minimale doit etre de 1")
	@Max(value = 6, message = "la valeur maximale doit etre 6")
	private Integer idDomainePro;

	private String libelleDomainePro;

	public int getIdDomainePro() {
		return idDomainePro;
	}

	public void setIdDomainePro(Integer idDomainePro) {
		this.idDomainePro = idDomainePro;
	}

	public String getLibelleDomainePro() {
		return libelleDomainePro;
	}

	public void setLibelleDomainePro(String libelleDomainePro) {
		this.libelleDomainePro = libelleDomainePro;
	}
	
	
}
