package fr.move.in.med.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "patient"
 * 
 */
public class PatientVo {

	private int idPatient;

	private String nom;

	private String prenom;

	private String adresseMail;

	private Date dateNaissance;

	private Set<ProfessionnelVo> listProfessionnel = new HashSet<ProfessionnelVo>();

	private List<AdresseVo> listAdresses = new ArrayList<AdresseVo>();

	public PatientVo() {
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

	public List<AdresseVo> getListAdresses() {
		return listAdresses;
	}

	public void setListAdresses(List<AdresseVo> listAdresses) {
		this.listAdresses = listAdresses;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<ProfessionnelVo> getListProfessionnel() {
		return listProfessionnel;
	}

	public void setListProfessionnel(Set<ProfessionnelVo> listProfessionnel) {
		this.listProfessionnel = listProfessionnel;
	}

}
