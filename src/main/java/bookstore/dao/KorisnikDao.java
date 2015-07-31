package bookstore.dao;

import java.util.List;

import bookstore.model.Korisnik;

public interface KorisnikDao {

	public Korisnik napraviKorisnika(Korisnik k);

	public Korisnik vratiKorisnika(Long korisnik_id);

	public Korisnik vratiKorisnikaPoKorisnickomImenu(String username);

	public List<Korisnik> vratiSveKorisnike();
}
