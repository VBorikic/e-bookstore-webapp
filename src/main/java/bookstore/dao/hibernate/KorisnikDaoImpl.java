package bookstore.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import bookstore.dao.KorisnikDao;
import bookstore.model.Korisnik;

@Component
public class KorisnikDaoImpl implements KorisnikDao {
	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);

	protected SessionFactory sessionFactory;

	// @PersistenceContext
	// private EntityManager em;

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
		System.out.println("Pre" + username);
		List<Korisnik> korisnici = sessionFactory.getCurrentSession()
				.createQuery("SELECT k FROM Korisnik k WHERE k.username='" + username + "'").list();
		System.out.println("Posle" + username);
		// query.setParameter(1, username);
		// List<Korisnik> korisnici = query.getResultList();
		if (korisnici.size() == 0) {
			return null;
		}
		else {
			return korisnici.get(0);
		}
	}

	@Override
	public List<Korisnik> vratiSveKorisnike() {
		return (List<Korisnik>) sessionFactory.getCurrentSession().createQuery("from Korisnik").list();
		// return query.getResultList();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
