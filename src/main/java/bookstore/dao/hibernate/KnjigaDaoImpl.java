package bookstore.dao.hibernate;

import java.util.List;

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
		return (Long) sessionFactory.getCurrentSession().save(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return (List<Knjiga>) sessionFactory.getCurrentSession().createQuery("from Knjiga").list();
	}

	@Override
	public Knjiga vratiKnigu(Long isbn) {
		// TODO Auto-generated method stub
		return (Knjiga) sessionFactory.getCurrentSession().get(Knjiga.class, isbn);
	}

	@Override
	public void obrisiKnjigu(Long isbn) {
		sessionFactory.getCurrentSession().delete(vratiKnigu(isbn));

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
