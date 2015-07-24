package bookstore.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.KorisnikDao;
import bookstore.model.Korisnik;

public class KorisnikDaoImpl implements KorisnikDao {
	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);
	protected SessionFactory sessionFactory;

	@Override
	public Long napraviKorisnika(Korisnik k) {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().save(k);
	}

	@Override
	public Korisnik vratiKorisnika(Long korisnik_id) {
		return (Korisnik) sessionFactory.getCurrentSession().get(Korisnik.class, korisnik_id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
