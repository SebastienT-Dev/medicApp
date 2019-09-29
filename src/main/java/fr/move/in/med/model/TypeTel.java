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
 * Classe représentant le modéle de donnée pour la table "type_tel"
 * 
 */
@Entity
@Table(name = "type_tel")
public class TypeTel {
	
	@Id
	@Column(name = "idTypeTel")
	@Mapping(value = "idTypeTel")
	private Integer idTypeTel;
	
	@Column(name = "libelleTypeTel")
	private String libelleTypeTel;

	public TypeTel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeTel(Integer idTypeTel, String libelleTypeTel) {
		super();
		this.idTypeTel = idTypeTel;
		this.libelleTypeTel = libelleTypeTel;
	}

	public int getIdTypeTel() {
		return idTypeTel;
	}

	public void setIdTypeTel(Integer idTypeTel) {
		this.idTypeTel = idTypeTel;
	}

	public String getLibelleTypeTel() {
		return libelleTypeTel;
	}

	public void setLibelleTypeTel(String libelleTypeTel) {
		this.libelleTypeTel = libelleTypeTel;
	}
	
	
}
