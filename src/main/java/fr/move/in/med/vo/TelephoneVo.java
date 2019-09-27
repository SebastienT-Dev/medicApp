package fr.move.in.med.vo;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "telephone"
 * 
 */

public class TelephoneVo {

	private String idTel;

	private String numeroTel;

	private TypeTelVo typeTelephone;

	public TelephoneVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TelephoneVo(String idTel, String numeroTel, TypeTelVo typeTelephone) {
		super();
		this.idTel = idTel;
		this.numeroTel = numeroTel;
		this.typeTelephone = typeTelephone;
	}

	public String getIdTel() {
		return idTel;
	}

	public void setIdTel(String idTel) {
		this.idTel = idTel;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public TypeTelVo getTypeTelephone() {
		return typeTelephone;
	}

	public void setTypeTelephone(TypeTelVo typeTelephone) {
		this.typeTelephone = typeTelephone;
	}

}
