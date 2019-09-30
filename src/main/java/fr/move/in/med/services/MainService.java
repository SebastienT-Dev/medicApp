package fr.move.in.med.services;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import fr.move.in.med.dao.PatientDao;
import fr.move.in.med.dao.ProfessionnelDao;
import fr.move.in.med.model.Adresse;
import fr.move.in.med.model.DomainePro;
import fr.move.in.med.model.Patient;
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.vo.AdresseVo;
import fr.move.in.med.vo.DomaineProVo;
import fr.move.in.med.vo.PatientVo;
import fr.move.in.med.vo.ProfessionnelVo;

public abstract class MainService {
	
	@Autowired
	protected ProfessionnelDao professionnelDao;
	
	@Autowired
	protected PatientDao patientDao;
	
	
	public List<?> getPatientOrProByCriterias(Object myObject, String typeTri, StringBuilder str, boolean isInvokeQuery, String alias)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (myObject == null || (!(myObject instanceof PatientVo) && !(myObject instanceof ProfessionnelVo))) {

		}
		
		PatientDao patientDao = null;
		ProfessionnelDao proDao = null;
		Boolean isInstanceOfPro = false;
		
		if (myObject instanceof PatientVo || myObject instanceof ProfessionnelVo) {
			boolean isInstancePatient = myObject instanceof PatientVo;
			
			
			if (isInstancePatient) {
				patientDao = this.patientDao;
				PatientVo myPatient = (PatientVo) myObject;
				boolean isContainAdress = CollectionUtils.isNotEmpty(myPatient.getListAdresses());
				str.append(String.format("from %s as p ", Patient.class.getName()));
				
				if (isContainAdress) {
					str.append(String.format(", %s as a ", Adresse.class.getName()));
				}
				
				str.append("where ");
				
				if (isContainAdress) {
					str.append("p.idPatient = a.monPatient.idPatient and ");
				}
				
			} else {
				isInstanceOfPro = true;
				proDao = this.professionnelDao;
				ProfessionnelVo  myPro = (ProfessionnelVo) myObject;
				boolean isContainAdress = CollectionUtils.isNotEmpty(myPro.getListAdresses());
				boolean isDomaineProNotNull = myPro.getDomaineProfessionnel() != null;
				str.append(String.format("from %s as p ", Professionnel.class.getName()));
				
				if (isContainAdress) {
					str.append(String.format(", %s as a ", Adresse.class.getName()));
				}
				
				if (myPro.getDomaineProfessionnel() != null) {
					str.append(String.format(", %s as dp ", DomainePro.class.getName()));
				}
				
				str.append("where ");
				
				if (isContainAdress) {
					str.append("p.idPro = a.monPro.idPro and ");
				}
				
				if (isDomaineProNotNull) {
					str.append("p.domaineProfessionnel.idDomainePro = dp.idDomainePro and ");
				}
			}
		}
		

		for (Method m : myObject.getClass().getDeclaredMethods()) {
			if (StringUtils.startsWith(m.getName(), "get") && !StringUtils.startsWith(m.getName(), "getId")) {
				Object value = m.invoke(myObject);

				if (value != null && !(value instanceof ArrayList<?>) && !(value instanceof HashSet<?>) && !(value instanceof DomaineProVo)) {
					String property = StringUtils.substring(m.getName(), 3);
						property = Character.toLowerCase(property.charAt(0)) + StringUtils.substring(property, 1);
						
						str.append(String.format("%s.", alias)).append(property).append(" = '")
						.append(value).append("'").append(" and ");
				

				} else if(value instanceof  ArrayList<?> && CollectionUtils.isNotEmpty((Collection<?>) value) && ((ArrayList<?>) value).get(0) instanceof AdresseVo){
					List<?> listValue = (List<?>) value;
					this.getPatientOrProByCriterias((AdresseVo) listValue.get(0), null, str, false, "a");
				} else if (value instanceof DomaineProVo) {
					this.getPatientOrProByCriterias(value, null, str, false, "dp");
				}

			}
		}

		
		if (isInvokeQuery) {
			
			String query = str.toString().trim();
			if (StringUtils.endsWith(query, "and")) {
				query = query.substring(0, query.length() - 3);
			}
			
			str = new StringBuilder(query);
			
			if (StringUtils.isNotBlank(typeTri)) {
				str.append(String.format("order by %s.nom ", alias)).append(typeTri).append(String.format(", %s.prenom ", alias)).append(typeTri);
				
				if (isInstanceOfPro) {
					str.append(", p.domaineProfessionnel.libelleDomainePro ").append(typeTri);
				}
			} else {
				str.append(String.format("order by %s.nom, %s.prenom ", alias, alias));
				
				if (isInstanceOfPro) {
					str.append(", p.domaineProfessionnel.libelleDomainePro ");
				}
			}
			
			
			List<?> listToReturn = new ArrayList<Object>();
			if (proDao != null) {
				listToReturn = proDao.findProByCriteria(str.toString());
			} else {
				listToReturn = patientDao.findPatientsByCriteria(str.toString());
			}
			
			return listToReturn;
		}
		
		return null;
	}
}
