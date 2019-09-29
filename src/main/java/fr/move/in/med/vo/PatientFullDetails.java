package fr.move.in.med.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientFullDetails {

	private String idPatient;

	private String nom;

	private String prenom;

	private String adresseMail;

	private Date dateNaissance;

	private List<AdresseVo> listAdresses = new ArrayList<AdresseVo>();

	public PatientFullDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientFullDetails(String idPatient, String nom, String prenom, String adresseMail, Date dateNaissance,
			List<AdresseVo> listAdresses) {
		super();
		this.idPatient = idPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.dateNaissance = dateNaissance;
		this.listAdresses = listAdresses;
	}

	public String getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(String idPatient) {
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<AdresseVo> getListAdresses() {
		return listAdresses;
	}

	public void setListAdresses(List<AdresseVo> listAdresses) {
		this.listAdresses = listAdresses;
	}

}
