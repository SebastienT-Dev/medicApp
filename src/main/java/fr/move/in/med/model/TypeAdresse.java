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
 * Classe représentant le modéle de donnée pour la table "type_adresse"
 * 
 */
@Entity
@Table(name = "type_adresse")
public class TypeAdresse {
	
	@Id
	@Column(name = "idTypeAdresse")
	@Mapping(value = "idTypeAdresse")
	private Integer idTypeAdresse;
	
	@Column(name = "libelleTypeAdresse")
	private String libelleTypeAdresse;

	public TypeAdresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeAdresse(Integer idTypeAdresse, String libelleTypeAdresse) {
		super();
		this.idTypeAdresse = idTypeAdresse;
		this.libelleTypeAdresse = libelleTypeAdresse;
	}

	public int getIdTypeAdresse() {
		return idTypeAdresse;
	}

	public void setIdTypeAdresse(Integer idTypeAdresse) {
		this.idTypeAdresse = idTypeAdresse;
	}

	public String getLibelleTypeAdresse() {
		return libelleTypeAdresse;
	}

	public void setLibelleTypeAdresse(String libelleTypeAdresse) {
		this.libelleTypeAdresse = libelleTypeAdresse;
	}
	
	
}
