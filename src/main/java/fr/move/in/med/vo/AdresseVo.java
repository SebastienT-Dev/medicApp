package fr.move.in.med.vo;

import org.dozer.Mapping;

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

	private Integer numero;

	private String adresse;

	private TypeAdresseVo typeAdresse;

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

}
