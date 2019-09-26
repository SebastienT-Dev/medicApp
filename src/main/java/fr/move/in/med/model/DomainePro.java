package fr.move.in.med.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "domaine_pro"
 * 
 */
@Entity
@Table(name = "domaine_pro")
public class DomainePro {
	
	@Id
	@Column(name = "idDomainePro")
	private int idDomainePro;
	
	@Column(name = "libelleDomainePro")
	private String libelleDomainePro;
}
