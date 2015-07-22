package bookstore.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.KorisnikDao;
import bookstore.dao.NarudzbenicaDao;
import bookstore.model.Narudzbenica;

public class NarudzbenicaDaoImpl implements NarudzbenicaDao {

	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);
	protected SessionFactory sessionFactory;
	protected KorisnikDao korisnikDao;

	@Override
	public Long napraviNarudzbenicu(Narudzbenica n) {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().save(n);
	}

	// settet i getter
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public KorisnikDao getKorisnikDao() {
		return korisnikDao;
	}

	public void setKorisnikDao(KorisnikDao korisnikDao) {
		this.korisnikDao = korisnikDao;
	}

}
