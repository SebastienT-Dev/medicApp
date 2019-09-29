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
 *        Classe représentant le modéle de donnée pour la table "adresse"
 * 
 */
@Entity
@Table(name = "adresse")
public class Adresse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdresse")
	@Mapping(value = "idAdresse")
	private Integer idAdresse;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "adresse")
	private String adresse;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idTypeAdresse")
	private TypeAdresse typeAdresse;

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypeAdresse getTypeAdresse() {
		return typeAdresse;
	}

	public void setTypeAdresse(TypeAdresse typeAdresse) {
		this.typeAdresse = typeAdresse;
	}

}
