package fr.move.in.med.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constant {

	private static final Map<Integer, String> MAP_DOMAINE_PRO = initMapDomainePro();

	private static final Map<Integer, String> MAP_TYPE_ADRESSE = initMapTypeAdresse();

	private static final Map<Integer, String> MAP_TYPE_TEL = initMapTypeTel();

	private static Map<Integer, String> initMapDomainePro() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Médecin généraliste");
		map.put(2, "Chirurgien");
		map.put(3, "Infirmier");
		map.put(4, "Kinésithérapeute");
		map.put(5, "Assistante sociale");
		map.put(6, "Psychologue");
		return Collections.unmodifiableMap(map);
	}

	private static Map<Integer, String> initMapTypeAdresse() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "MOBILE");
		map.put(2, "MAISON");
		map.put(3, "TRAVAIL");
		map.put(4, "ECOLE");
		map.put(5, "AUTRE");
		return Collections.unmodifiableMap(map);
	}

	private static Map<Integer, String> initMapTypeTel() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "MOBILE");
		map.put(2, "MAISON");
		map.put(3, "TRAVAIL");
		map.put(4, "AUTRE");

		return Collections.unmodifiableMap(map);
	}

	public static Map<Integer, String> getMapDomainePro() {
		return MAP_DOMAINE_PRO;
	}

	public static Map<Integer, String> getMapTypeAdresse() {
		return MAP_TYPE_ADRESSE;
	}

	public static Map<Integer, String> getMapTypeTel() {
		return MAP_TYPE_TEL;
	}

}
