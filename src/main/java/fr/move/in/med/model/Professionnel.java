package fr.move.in.med.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "professionnel"
 * 
 */
@Entity
@Table(name = "professionnel")
public class Professionnel {

	@Id
	@GeneratedValue
	@Column(name = "idPro", nullable = false)
	private int idPro;

	@Column(name = "nom", nullable = false)
	private String nom;

	@Column(name = "prenom", nullable = false)
	private String prenom;

	@Column(name = "adresseMail")
	private String adresseMail;

	@ManyToOne
	@JoinColumn(name = "idDomainePro")
	private DomainePro domaineProfessionnel;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "affiliation_patient_pro", joinColumns = { @JoinColumn(name = "idPro") }, inverseJoinColumns = {
			@JoinColumn(name = "idPatient") })
	@JsonIgnore
	private Set<Patient> listPatients = new HashSet<Patient>();

	public Professionnel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public DomainePro getDomaineProfessionnel() {
		return domaineProfessionnel;
	}

	public void setDomaineProfessionnel(DomainePro domaineProfessionnel) {
		this.domaineProfessionnel = domaineProfessionnel;
	}

	public Set<Patient> getListPatients() {
		return listPatients;
	}

	public void setListPatients(Set<Patient> listPatients) {
		this.listPatients = listPatients;
	}

}
