package fr.move.in.med.model;

import java.util.HashSet;
import java.util.Set;

public class Professionnel extends Personne {
	
	private DomainePro domaineProfessionnel;
	
	private Set<Patient> listPatients = new HashSet<Patient>();
}
