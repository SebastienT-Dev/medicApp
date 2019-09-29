package fr.move.in.med.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dozer.Mapping;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "telephone"
 * 
 */
@Entity
@Table(name = "telephone")
public class Telephone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTel")
	@Mapping(value = "idTel")
	private Integer idTel;
	
	@Column(name = "numeroTel")
	private String numeroTel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idTypeTel")
	private TypeTel typeTelephone;

	public Telephone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telephone(Integer idTel, String numeroTel, TypeTel typeTelephone) {
		super();
		this.idTel = idTel;
		this.numeroTel = numeroTel;
		this.typeTelephone = typeTelephone;
	}

	public Integer getIdTel() {
		return idTel;
	}

	public void setIdTel(Integer idTel) {
		this.idTel = idTel;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public TypeTel getTypeTelephone() {
		return typeTelephone;
	}

	public void setTypeTelephone(TypeTel typeTelephone) {
		this.typeTelephone = typeTelephone;
	}
	
	
}
