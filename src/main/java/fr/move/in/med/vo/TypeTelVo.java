package fr.move.in.med.vo;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "type_tel"
 * 
 */
public class TypeTelVo {

	private int idTypeTel;

	private String libelleTypeTel;

	public TypeTelVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeTelVo(int idTypeTel, String libelleTypeTel) {
		super();
		this.idTypeTel = idTypeTel;
		this.libelleTypeTel = libelleTypeTel;
	}

	public int getIdTypeTel() {
		return idTypeTel;
	}

	public void setIdTypeTel(int idTypeTel) {
		this.idTypeTel = idTypeTel;
	}

	public String getLibelleTypeTel() {
		return libelleTypeTel;
	}

	public void setLibelleTypeTel(String libelleTypeTel) {
		this.libelleTypeTel = libelleTypeTel;
	}

}
