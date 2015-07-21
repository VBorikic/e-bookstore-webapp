package bookstore.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.AutorDao;
import bookstore.dao.IzdavacDao;
import bookstore.dao.KnjigaDao;
import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Knjiga;

public class BookStoreServiceImpl implements BookStoreService {

	Logger logger = LoggerFactory.getLogger(BookStoreServiceImpl.class);

	protected AutorDao autorDao;
	protected IzdavacDao izdavacDao;
	protected KnjigaDao knjigaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Autor> vratiSveAutore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Izdavac> vratiSveIzdavace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Knjiga unesiNovuKnjigu(Knjiga knjiga) {
		// TODO Auto-generated method stub
		return null;
	}

	// setters and getters
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

	public KnjigaDao getKnjigaDao() {
		return knjigaDao;
	}

	public void setKnjigaDao(KnjigaDao knjigaDao) {
		this.knjigaDao = knjigaDao;
	}

}
