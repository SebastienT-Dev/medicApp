package fr.move.in.med.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dozer.Mapping;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "domaine_pro"
 * 
 */
@Entity
@Table(name = "domaine_pro")
public class DomainePro {

	@Id
	@Column(name = "idDomainePro")
	@Mapping(value = "idDomainePro")
	private Integer idDomainePro;

	@Column(name = "libelleDomainePro")
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
