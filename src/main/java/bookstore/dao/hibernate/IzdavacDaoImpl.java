package bookstore.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.IzdavacDao;
import bookstore.model.Izdavac;

public class IzdavacDaoImpl implements IzdavacDao {

	Logger logger = LoggerFactory.getLogger(IzdavacDaoImpl.class);
	protected SessionFactory sessionFactory;

	@Override
	public List<Izdavac> vratiSveIzdavace() {
		return (List<Izdavac>) sessionFactory.getCurrentSession().createQuery("from izdavac").list();
	}

	// setter and getter
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
