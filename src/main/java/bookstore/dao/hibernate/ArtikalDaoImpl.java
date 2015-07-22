package bookstore.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.ArtikalDao;
import bookstore.dao.KnjigaDao;
import bookstore.dao.NarudzbenicaDao;
import bookstore.model.Artikal;

public class ArtikalDaoImpl implements ArtikalDao {
	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);
	protected SessionFactory sessionFactory;
	protected NarudzbenicaDao narudzbenicaDao;
	protected KnjigaDao knjigaDao;

	@Override
	public Artikal ubaciArtikal(Artikal a) {
		// TODO Auto-generated method stub
		return null;
	}

	// setter i getter
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public NarudzbenicaDao getNarudzbenicaDao() {
		return narudzbenicaDao;
	}

	public void setNarudzbenicaDao(NarudzbenicaDao narudzbenicaDao) {
		this.narudzbenicaDao = narudzbenicaDao;
	}

	public KnjigaDao getKnjigaDao() {
		return knjigaDao;
	}

	public void setKnjigaDao(KnjigaDao knjigaDao) {
		this.knjigaDao = knjigaDao;
	}

}
