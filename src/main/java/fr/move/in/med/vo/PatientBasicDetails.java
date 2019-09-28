package fr.move.in.med.vo;

public class PatientBasicDetails {

	private String nom;

	private String prenom;

	private String dateNaissance;

	public PatientBasicDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientBasicDetails(String nom, String prenom, String dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
