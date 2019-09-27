package fr.move.in.med.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "patient"
 * 
 */
@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue
	@Column(name = "idPatient", nullable = false)
	private int idPatient;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "prenom", nullable = false)
	private String prenom;
	
	@Column(name = "adresseMail")
	private String adresseMail;
	
	@Column(name = "dateNaissance")
	private Date dateNaissance;
	
	@ManyToMany(mappedBy = "listPatients")
	@JsonIgnore
	private Set<Professionnel> listProfessionnel = new HashSet<Professionnel>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPatient")
	private List<Adresse> listAdresses = new ArrayList<Adresse>();

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
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


	public List<Adresse> getListAdresses() {
		return listAdresses;
	}


	public void setListAdresses(List<Adresse> listAdresses) {
		this.listAdresses = listAdresses;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Professionnel> getListProfessionnel() {
		return listProfessionnel;
	}

	public void setListProfessionnel(Set<Professionnel> listProfessionnel) {
		this.listProfessionnel = listProfessionnel;
	}
	
	
}
