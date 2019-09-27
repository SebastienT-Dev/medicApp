package fr.move.in.med.vo;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "type_adresse"
 * 
 */
public class TypeAdresseVo {

	private int idTypeAdresse;

	private String libelleTypeAdresse;

	public TypeAdresseVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeAdresseVo(int idTypeAdresse, String libelleTypeAdresse) {
		super();
		this.idTypeAdresse = idTypeAdresse;
		this.libelleTypeAdresse = libelleTypeAdresse;
	}

	public int getIdTypeAdresse() {
		return idTypeAdresse;
	}

	public void setIdTypeAdresse(int idTypeAdresse) {
		this.idTypeAdresse = idTypeAdresse;
	}

	public String getLibelleTypeAdresse() {
		return libelleTypeAdresse;
	}

	public void setLibelleTypeAdresse(String libelleTypeAdresse) {
		this.libelleTypeAdresse = libelleTypeAdresse;
	}

}
