package fr.move.in.med.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.dozer.Mapping;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "type_adresse"
 * 
 */
public class TypeAdresseVo {
	
	@Mapping(value = "idTypeAdresse")
	@Min(value = 1, message = "la valeur minimale doit etre de 1")
	@Max(value = 5, message = "la valeur maximale doit etre 5")
	private Integer idTypeAdresse;

	private String libelleTypeAdresse;

	public TypeAdresseVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeAdresseVo(Integer idTypeAdresse, String libelleTypeAdresse) {
		super();
		this.idTypeAdresse = idTypeAdresse;
		this.libelleTypeAdresse = libelleTypeAdresse;
	}

	public int getIdTypeAdresse() {
		return idTypeAdresse;
	}

	public void setIdTypeAdresse(Integer idTypeAdresse) {
		this.idTypeAdresse = idTypeAdresse;
	}

	public String getLibelleTypeAdresse() {
		return libelleTypeAdresse;
	}

	public void setLibelleTypeAdresse(String libelleTypeAdresse) {
		this.libelleTypeAdresse = libelleTypeAdresse;
	}

}
