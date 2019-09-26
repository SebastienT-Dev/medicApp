package fr.move.in.med.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MainDao {
	
	@Autowired
	protected SessionFactory sessionFactory;
}
