package fr.move.in.med.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {

	@Autowired
	private Mapper mapper;

	public Object convertObject(Object sourceObject, Class<?> destinationClass) {
		return mapper.map(sourceObject, destinationClass);
	}

	public List<Object> convertListObject(List<?> listObject, Class<?> destinationClass) {
		List<Object> listConvert = new ArrayList<Object>();

		if (CollectionUtils.isEmpty(listObject)) {
			return listConvert;
		}

		for (Object object : listObject) {
			Object o = mapper.map(object, destinationClass);
			listConvert.add(o);
		}

		return listConvert;
	}
}
