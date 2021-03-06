package bookstore.services;

import java.util.List;

import bookstore.model.Korisnik;

public interface KorisnikService {

	public Korisnik pronadjiKorisnika(Long id);

	public Korisnik napraviNovogKorisnika(Korisnik k);

	public Korisnik pronadjiKorisnikaPoKorisnickomImenu(String username);

	public List<Korisnik> vratiSveKorisnike();

}
