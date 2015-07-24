package bookstore.dao;

import bookstore.model.Korisnik;

public interface KorisnikDao {

	public Long napraviKorisnika(Korisnik k);

	public Korisnik vratiKorisnika(Long korisnik_id);
}
