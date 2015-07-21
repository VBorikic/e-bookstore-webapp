package bookstore.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.AutorDao;
import bookstore.model.Autor;

public class AutorDaoImpl implements AutorDao {

	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);
	protected SessionFactory sessionFactory;

	@Override
	public List<Autor> vratiSveAutore() {

		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// setters and getters

}
