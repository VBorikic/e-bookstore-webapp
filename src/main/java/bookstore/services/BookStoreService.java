package bookstore.services;

import java.util.List;

import bookstore.model.Artikal;
import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Knjiga;
import bookstore.model.Korisnik;
import bookstore.model.Narudzbenica;

public interface BookStoreService {

	public List<Autor> vratiSveAutore();

	public List<Izdavac> vratiSveIzdavace();

	public Knjiga unesiNovuKnjigu(Knjiga knjiga);

	public List<Knjiga> vratiSveKnjige();

	// da se dodaju metode koje trebaju
	public Artikal ubaciArtikal(Artikal a);

	public Korisnik napraviKorisnika(Korisnik k);

	public Narudzbenica napraviNarudzbenicu(Narudzbenica n);
}
