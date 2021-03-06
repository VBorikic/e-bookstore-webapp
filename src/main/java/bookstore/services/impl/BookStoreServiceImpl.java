package bookstore.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.ArtikalDao;
import bookstore.dao.AutorDao;
import bookstore.dao.IzdavacDao;
import bookstore.dao.KnjigaDao;
import bookstore.dao.NarudzbenicaDao;
import bookstore.model.Artikal;
import bookstore.model.ArtikalPK;
import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Knjiga;
import bookstore.model.Narudzbenica;
import bookstore.services.BookStoreService;

public class BookStoreServiceImpl implements BookStoreService {

	Logger logger = LoggerFactory.getLogger(BookStoreServiceImpl.class);

	protected AutorDao autorDao;

	protected IzdavacDao izdavacDao;

	protected KnjigaDao knjigaDao;

	protected ArtikalDao artikalDao;

	protected NarudzbenicaDao narudzbenicaDao;

	// TO DO da se dodaju sve metode
	@Override
	@Transactional(readOnly = true)
	public List<Autor> vratiSveAutore() {
		return autorDao.vratiSveAutore();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Izdavac> vratiSveIzdavace() {
		// TODO Auto-generated method stub
		return izdavacDao.vratiSveIzdavace();
	}

	@Override
	@Transactional
	public Knjiga unesiNovuKnjigu(Knjiga knjiga) {
		// TODO Auto-generated method stub
		Long isbn = knjigaDao.unesiNovuKnjigu(knjiga);
		return knjigaDao.vratiKnigu(isbn);
	}

	@Override
	@Transactional
	public void izmeniKnjigu(Knjiga knjiga) {
		knjigaDao.izmeniKnjigu(knjiga);

	}

	@Override
	@Transactional
	public void obrisiKnjigu(Long isbn) {
		knjigaDao.obrisiKnjigu(isbn);

	}

	@Override
	@Transactional
	public Artikal ubaciArtikal(Artikal a) {
		ArtikalPK artikalID = artikalDao.ubaciArtikal(a);
		return artikalDao.vratiArtikal(artikalID);
	}

	@Override
	@Transactional
	public Artikal vratiArtikal(ArtikalPK a_id) {
		// TODO Auto-generated method stub
		return artikalDao.vratiArtikal(a_id);
	}

	@Override
	@Transactional
	public Narudzbenica napraviNarudzbenicu(Narudzbenica n) {
		// for (Artikal artikal : n.getListaArtikala()) {
		// artikalDao.ubaciArtikal(artikal);
		// logger.debug("ubacen artikal");
		// }
		Long na_id = narudzbenicaDao.napraviNarudzbenicu(n);
		return narudzbenicaDao.vratiNarudzbenicu(na_id);
	}

	@Override
	@Transactional
	public void sacuvajNarudzbenicu(Narudzbenica n) {
		for (Artikal artikal : n.getListaArtikala()) {
			artikalDao.ubaciArtikal(artikal);
			logger.debug("ubacen artikal");
		}
		narudzbenicaDao.izmeniNarudzbenicu(n);

	}

	@Override
	@Transactional
	public Narudzbenica vratiNarudzbenicu(Long nar_id) {
		// TODO Auto-generated method stub
		return narudzbenicaDao.vratiNarudzbenicu(nar_id);
	}

	@Override
	@Transactional
	public List<Narudzbenica> vratiSveNarudzbenice() {
		return narudzbenicaDao.vratiSveNarudzbenice();
	}

	@Override
	@Transactional
	public List<Knjiga> vratiSveKnjige() {
		// TODO Auto-generated method stub
		return knjigaDao.vratiSveKnjige();
	}

	@Override
	@Transactional
	public Knjiga vratiKnjigu(Long isbn) {
		// TODO Auto-generated method stub
		return knjigaDao.vratiKnigu(isbn);
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

	public ArtikalDao getArtikalDao() {
		return artikalDao;
	}

	public void setArtikalDao(ArtikalDao artikalDao) {
		this.artikalDao = artikalDao;
	}

	public NarudzbenicaDao getNarudzbenicaDao() {
		return narudzbenicaDao;
	}

	public void setNarudzbenicaDao(NarudzbenicaDao narudzbenicaDao) {
		this.narudzbenicaDao = narudzbenicaDao;
	}

}
