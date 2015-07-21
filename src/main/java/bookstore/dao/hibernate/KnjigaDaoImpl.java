package bookstore.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.AutorDao;
import bookstore.dao.IzdavacDao;
import bookstore.dao.KnjigaDao;
import bookstore.model.Knjiga;

public class KnjigaDaoImpl implements KnjigaDao {
	Logger logger = LoggerFactory.getLogger(KnjigaDaoImpl.class);
	protected SessionFactory sessionFactory;
	protected AutorDao autorDao;
	protected IzdavacDao izdavacDao;

	@Override
	public Long unesiNovuKnjigu(Knjiga knjiga) {
		// TODO Auto-generated method stub
		return null;
	}

	// setters and getters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AutorDao getAutorDao() {
		return autorDao;
	}

	public void setAutorDao(AutorDao autorDao) {
		this.autorDao = autorDao;
	}

	public IzdavacDao getIzdavacDao() {
		return izdavacDao;
	}

	public void setIzdavacDao(IzdavacDao izdavacDao) {
		this.izdavacDao = izdavacDao;
	}

}
