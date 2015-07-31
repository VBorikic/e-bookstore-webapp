package bookstore.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.dao.KorisnikDao;
import bookstore.model.Korisnik;
import bookstore.services.KorisnikService;
import bookstore.services.exceptions.AccountExistsException;

public class KorisnikServiceImpl implements KorisnikService {

	Logger logger = LoggerFactory.getLogger(KorisnikServiceImpl.class);

	protected KorisnikDao korisnikDao;

	@Override
	public Korisnik pronadjiKorisnika(Long id) {
		return korisnikDao.vratiKorisnika(id);
	}

	@Override
	public Korisnik napraviNovogKorisnika(Korisnik k) {
		Korisnik korisnik = korisnikDao.vratiKorisnikaPoKorisnickomImenu(k.getUserName());
		if (korisnik != null) {
			throw new AccountExistsException("Korisnik vec postoji");
		}
		return korisnikDao.napraviKorisnika(k);
	}

	@Override
	public Korisnik pronadjiKorisnikaPoKorisnickomImenu(String username) {
		return korisnikDao.vratiKorisnikaPoKorisnickomImenu(username);
	}

	public KorisnikDao getKorisnikDao() {
		return korisnikDao;
	}

	public void setKorisnikDao(KorisnikDao korisnikDao) {
		this.korisnikDao = korisnikDao;
	}
}
