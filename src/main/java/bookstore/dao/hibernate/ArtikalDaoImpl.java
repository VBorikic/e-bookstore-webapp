package bookstore.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.ArtikalDao;
import bookstore.dao.KnjigaDao;
import bookstore.dao.NarudzbenicaDao;
import bookstore.model.Artikal;
import bookstore.model.ArtikalPK;

public class ArtikalDaoImpl implements ArtikalDao {
	Logger logger = LoggerFactory.getLogger(AutorDaoImpl.class);
	protected SessionFactory sessionFactory;
	protected NarudzbenicaDao narudzbenicaDao;
	protected KnjigaDao knjigaDao;

	@Override
	public ArtikalPK ubaciArtikal(Artikal a) {
		return (ArtikalPK) sessionFactory.getCurrentSession().save(a);
	}

	// ovde moze nastati greska kada treba da se uzme artikal
	@Override
	public Artikal vratiArtikal(ArtikalPK artikal_id) {
		// TODO Auto-generated method stub
		return (Artikal) sessionFactory.getCurrentSession().get(Artikal.class, artikal_id);
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
