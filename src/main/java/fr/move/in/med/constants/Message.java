package fr.move.in.med.constants;

public class Message {
	
	private Message() {
		//Classe de consantes
	}
	
	public static final String HIBERNATE_ERROR = "Une erreur en relation avec la base de données c'est produite";
	public static final String MAPPING_ERROR = "Une erreur de mapping des objets JAVA a eu lieu";
	public static final String ILLEGAL_STATE_ERROR = "Invocation ou une utilisation inapproprié d'une méthode JAVA";
	
	//ERREUR DE VALIDATION
	public static final String NOM_EMPTY = "le nom doit etre au minimum renseigné";
	public static final String PRENOM_EMPTY = "le prénom doit etre au minimum renseigné";
	public static final String DATE_NAISSANCE_EMPTY = "le date de naissance doit etre au minimum renseigné";
	
	public static final String NOM_BLANK = "le nom que vous avez renseigné est une chaine vide";
	public static final String PRENOM_BLANK = "le prénom que vous avez renseigné est une chaine vide";
	public static final String DATE_NAISSANCE_BLANK = "le date de naissance que vous avez renseigné est une chaine vide";
	
	
}
