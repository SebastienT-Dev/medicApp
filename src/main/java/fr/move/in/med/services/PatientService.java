package fr.move.in.med.services;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.PatientDao;
import fr.move.in.med.model.Patient;
import fr.move.in.med.utils.MapperUtils;
import fr.move.in.med.vo.PatientVo;
import fr.move.in.med.vo.ProfessionnelBasicDetails;
import fr.move.in.med.vo.ProfessionnelVo;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	@Autowired
	protected MapperUtils mapper;

	/**
	 * Fonction permettant d'effectuer la recherche d'un patient à partir des
	 * critéres utilisateurs
	 * 
	 * @param monPatient
	 * @param typeTri
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<Object> getPatientByCriteria(PatientVo monPatient, String typeTri)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (monPatient == null) {

		}

		StringBuilder str = new StringBuilder("from Patient as p where ");
		int i = 0;
		for (Method m : monPatient.getClass().getDeclaredMethods()) {
			if (StringUtils.startsWith(m.getName(), "get") && !"getIdPatient".equalsIgnoreCase(m.getName())) {
				Object value = m.invoke(monPatient);

				if (value != null && !(value instanceof ArrayList<?>) && !(value instanceof HashSet<?>)) {

					if (i != 0) {
						str.append("and ");
					}

					str.append("p.").append(StringUtils.substring(m.getName().toLowerCase(), 3)).append(" = '")
							.append(value).append("' ");
					i++;

				}

			}
		}

		if (StringUtils.isNotBlank(typeTri)) {
			str.append("order by p.nom ").append(typeTri).append(", p.prenom ").append(typeTri)
					.append(", p.dateNaissance ").append(typeTri);
		} else {
			str.append("order by p.nom, p.prenom, p.dateNaissance ");
		}

		List<Object> listPatient = patientDao.findPatientsByCriteria(str.toString());
		return listPatient;

	}

	/**
	 * Fonction permettant de récupérer l'intégralité des patients
	 * 
	 * @return {@link ArrayList} retourne une liste d'objet {@link PatientVo}
	 */
	public List<Object> getAllPatient() {
		List<Object> listPatients = patientDao.retreiveAllPatients();

		if (CollectionUtils.isEmpty(listPatients)) {

		}
		return listPatients;
	}

	/**
	 * Fonction permettant de récupérer les professionnels d'un patient
	 * 
	 * @param id
	 * @return
	 */
	public List<Object> getProFromPatient(int id) {
		PatientVo monPatient = patientDao.findPatientById(id);
		Set<ProfessionnelVo> set = monPatient.getListProfessionnel();

		List<Object> listPro = mapper.convertListObject(set.stream().collect(Collectors.toList()),
				ProfessionnelBasicDetails.class);

		return listPro;

	}

	/**
	 * Procédure permettant de créer un nouveau patient
	 * 
	 * @param monPatient - le patient a créé
	 */
	public void createNewPatient(PatientVo monPatient) {
		patientDao.createPatientOrPro(monPatient, Patient.class);
	}

	/**
	 * Procédure permerttant de mettre à jour un patient
	 * 
	 * @param monPatient
	 * @param id
	 */
	public void updatePatient(PatientVo monPatient, int id) {
		patientDao.findPatientById(id);
		patientDao.updatePatientOrPro(monPatient, Patient.class, id);
	}

	/**
	 * 
	 * Procédure permettant de supprimer un patient
	 * 
	 * @param id
	 * @return
	 */
	public void deletePatient(long id) {
		PatientVo p = patientDao.findPatientById(id);

		if (p == null) {

		}

		patientDao.deletePatientOrPro(p, Patient.class);

	}
}
