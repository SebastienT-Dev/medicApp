package fr.move.in.med.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private String idTel;
	
	@Column(name = "numeroTel")
	private String numeroTel;
	
	@ManyToOne
	@JoinColumn(name = "idTypeTel")
	private TypeTel typeTelephone;

	public Telephone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telephone(String idTel, String numeroTel, TypeTel typeTelephone) {
		super();
		this.idTel = idTel;
		this.numeroTel = numeroTel;
		this.typeTelephone = typeTelephone;
	}

	public String getIdTel() {
		return idTel;
	}

	public void setIdTel(String idTel) {
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
