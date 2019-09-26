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

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "professionnel"
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
	private Set<Patient> listPatients = new HashSet<Patient>();

	public Professionnel() {
		super();
		// TODO Auto-generated constructor stub
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
