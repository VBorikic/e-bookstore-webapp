package bookstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.KorisnikDao;
import bookstore.model.Korisnik;
import bookstore.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	protected KorisnikDao korisnikDao;

	@Override
	@Transactional
	public Korisnik pronadjiKorisnikaPoKorisnickomImenu(String username) {
		if (korisnikDao == null) {
			System.out.println("korisnik dao je null");
		}
		return korisnikDao.vratiKorisnikaPoKorisnickomImenu(username);
	}

	public KorisnikDao getKorisnikDao() {
		return korisnikDao;
	}

	public void setKorisnikDao(KorisnikDao korisnikDao) {
		this.korisnikDao = korisnikDao;
	}

}
