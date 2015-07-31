package bookstore.services;

import bookstore.model.Korisnik;

public interface KorisnikService {

	public Korisnik findAccount(Long id);

	public Korisnik createAccount(Korisnik data);

	public Korisnik findByAccountName(String username);

}
