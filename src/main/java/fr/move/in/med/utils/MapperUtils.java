package fr.move.in.med.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {

	@Autowired
	private Mapper mapper;

	public Object convertObject(Object sourceObject, Class<?> destinationClass) {
		return this.mappingObject(sourceObject, destinationClass);
	}

	public List<Object> convertListObject(List<?> listObject, Class<?> destinationClass) {
		List<Object> listConvert = new ArrayList<Object>();

		if (CollectionUtils.isEmpty(listObject)) {
			return listConvert;
		}

		for (Object object : listObject) {
			listConvert.add(this.mappingObject(object, destinationClass));

		}

		return listConvert;
	}

	private Object mappingObject(Object o, Class<?> destinationClass) {
		Object myObject = null;
		myObject = mapper.map(o, destinationClass);

		return myObject;
	}
}
