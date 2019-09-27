package fr.move.in.med.vo;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 * Classe représentant le modéle de donnée pour la table "adresse"
 * 
 */
public class AdresseVo {

	private int idAdresse;

	private int numero;

	private String adresse;

	private TypeAdresseVo typeAdresse;

	public AdresseVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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
