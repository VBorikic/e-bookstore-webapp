package bookstore.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.KorisnikDao;
import bookstore.model.Korisnik;

public class KorisnikDaoImpl implements KorisnikDao {
	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);

	protected SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Korisnik napraviKorisnika(Korisnik k) {

		sessionFactory.getCurrentSession().save(k);
		return k;
	}

	@Override
	public Korisnik vratiKorisnika(Long korisnik_id) {
		return (Korisnik) sessionFactory.getCurrentSession().get(Korisnik.class, korisnik_id);
	}

	@Override
	public Korisnik vratiKorisnikaPoKorisnickomImenu(String username) {
		Query query = em.createQuery("SELECT k FROM Korisnik k WHERE k.username=?1");
		query.setParameter(1, username);
		List<Korisnik> korisnici = query.getResultList();
		if (korisnici.size() == 0) {
			return null;
		}
		else {
			return korisnici.get(0);
		}
	}

	@Override
	public List<Korisnik> vratiSveKorisnike() {
		Query query = em.createQuery("SELECT k FROM Korisnik k");
		return query.getResultList();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
