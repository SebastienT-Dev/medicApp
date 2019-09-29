package fr.move.in.med.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.dozer.Mapping;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "type_tel"
 * 
 */
public class TypeTelVo {
	
	@Mapping(value = "idTypeTel")
	@Min(value = 1, message = "la valeur minimale doit etre de 1")
	@Max(value = 4, message = "la valeur maximale doit etre 4")
	private Integer idTypeTel;

	private String libelleTypeTel;

	public TypeTelVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeTelVo(Integer idTypeTel, String libelleTypeTel) {
		super();
		this.idTypeTel = idTypeTel;
		this.libelleTypeTel = libelleTypeTel;
	}

	public int getIdTypeTel() {
		return idTypeTel;
	}

	public void setIdTypeTel(Integer idTypeTel) {
		this.idTypeTel = idTypeTel;
	}

	public String getLibelleTypeTel() {
		return libelleTypeTel;
	}

	public void setLibelleTypeTel(String libelleTypeTel) {
		this.libelleTypeTel = libelleTypeTel;
	}

}
