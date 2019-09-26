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
 * Classe représentant le modéle de donnée pour la table "adresse"
 * 
 */
@Entity
@Table(name = "adresse")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdresse")
	private int idAdresse;

	@Column(name = "numero")
	private int numero;

	@Column(name = "adresse")
	private String adresse;

	@ManyToOne
	@JoinColumn(name = "idTypeAdresse")
	private TypeAdresse typeAdresse;

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

}
