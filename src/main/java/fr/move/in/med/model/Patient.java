package fr.move.in.med.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Patient extends Personne {
	
	private Date dateNaissance;
	
	private Set<Professionnel> listProfessionnel = new HashSet<Professionnel>();
}
