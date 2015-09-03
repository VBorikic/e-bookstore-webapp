package bookstore.services;

import bookstore.model.Korisnik;

public interface UserService {
	public Korisnik pronadjiKorisnikaPoKorisnickomImenu(String username);

	public Korisnik napraviNovogKorisnika(Korisnik k);

}
