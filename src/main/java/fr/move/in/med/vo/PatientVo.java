package fr.move.in.med.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.dozer.Mapping;

import fr.move.in.med.constants.Message;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "patient"
 * 
 */
public class PatientVo {

	@Mapping(value = "idPatient")
	private Integer idPatient;
	
	@NotNull(message = Message.NOM_EMPTY)
	@NotBlank(message = Message.NOM_BLANK)
	private String nom;
	
	@NotNull(message = Message.NOM_EMPTY)
	@NotBlank(message = Message.NOM_BLANK)
	private String prenom;

	private String adresseMail;
	
	@NotNull(message = Message.DATE_NAISSANCE_EMPTY)
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

	public void setIdPatient(Integer idPatient) {
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
