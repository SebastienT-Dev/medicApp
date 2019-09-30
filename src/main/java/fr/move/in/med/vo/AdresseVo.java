package fr.move.in.med.vo;

import org.dozer.Mapping;

import fr.move.in.med.model.Professionnel;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "adresse"
 * 
 */
public class AdresseVo {
	
	@Mapping(value = "idAdresse")
	private Integer idAdresse;

	@Mapping(value = "numero")
	private Integer numero;

	private String adresse;

	private TypeAdresseVo typeAdresse;
	
	private PatientVo monPatient;
	
	private Professionnel monPro;
	

	public AdresseVo() {
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

	public TypeAdresseVo getTypeAdresse() {
		return typeAdresse;
	}

	public void setTypeAdresse(TypeAdresseVo typeAdresse) {
		this.typeAdresse = typeAdresse;
	}

	public PatientVo getMonPatient() {
		return monPatient;
	}

	public void setMonPatient(PatientVo monPatient) {
		this.monPatient = monPatient;
	}

	public Professionnel getMonPro() {
		return monPro;
	}

	public void setMonPro(Professionnel monPro) {
		this.monPro = monPro;
	}

}
