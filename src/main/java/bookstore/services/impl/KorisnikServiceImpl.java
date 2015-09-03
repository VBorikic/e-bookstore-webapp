package bookstore.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.KorisnikDao;
import bookstore.model.Korisnik;
import bookstore.services.KorisnikService;
import bookstore.services.exceptions.AccountExistsException;

@Service
// @Scope("prototype")
public class KorisnikServiceImpl implements KorisnikService {

	Logger logger = LoggerFactory.getLogger(KorisnikServiceImpl.class);

	@Autowired
	protected KorisnikDao korisnikDao;

	@Override
	@Transactional
	public Korisnik pronadjiKorisnika(Long id) {
		return korisnikDao.vratiKorisnika(id);
	}

	@Override
	@Transactional
	public Korisnik napraviNovogKorisnika(Korisnik k) {
		System.out.println("Uzeto od korisnika" + k.getUsername());
		Korisnik korisnik = korisnikDao.vratiKorisnikaPoKorisnickomImenu(k.getUsername());
		if (korisnik != null) {
			throw new AccountExistsException("Korisnik vec postoji");
		}
		return korisnikDao.napraviKorisnika(k);
	}

	@Override
	@Transactional
	public Korisnik pronadjiKorisnikaPoKorisnickomImenu(String username) {
		return korisnikDao.vratiKorisnikaPoKorisnickomImenu(username);
	}

	public KorisnikDao getKorisnikDao() {
		return korisnikDao;
	}

	public void setKorisnikDao(KorisnikDao korisnikDao) {
		this.korisnikDao = korisnikDao;
	}

	@Override
	@Transactional
	public List<Korisnik> vratiSveKorisnike() {
		return korisnikDao.vratiSveKorisnike();
	}

}
