package fr.move.in.med.vo;

public class ProfessionnelBasicDetails {

	private Integer idPro;

	private String nom;

	private String prenom;

	private DomaineProVo domaineProfessionnel;

	public ProfessionnelBasicDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfessionnelBasicDetails(String nom, String prenom, DomaineProVo domaineProfessionnel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.domaineProfessionnel = domaineProfessionnel;
	}

	public Integer getIdPro() {
		return idPro;
	}

	public void setIdPro(Integer idPro) {
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

	public DomaineProVo getDomaineProfessionnel() {
		return domaineProfessionnel;
	}

	public void setDomaineProfessionnel(DomaineProVo domaineProfessionnel) {
		this.domaineProfessionnel = domaineProfessionnel;
	}

}
