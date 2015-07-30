package bookstore.services;

import java.util.List;

import bookstore.model.Artikal;
import bookstore.model.ArtikalPK;
import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Knjiga;
import bookstore.model.Korisnik;
import bookstore.model.Narudzbenica;

public interface BookStoreService {

	// uradjeno u res
	public List<Autor> vratiSveAutore();

	// uradjeno u res
	public List<Izdavac> vratiSveIzdavace();

	// uradjeno u res
	public Knjiga unesiNovuKnjigu(Knjiga knjiga);

	// uradjeno u res
	public List<Knjiga> vratiSveKnjige();

	// uradjeno u res
	public Knjiga vratiKnjigu(Long isbn);

	public void izmeniKnjigu(Knjiga knjiga);

	public void obrisiKnjigu(Long isbn);
	// za srtikal mora slozen kljuc

	public Artikal vratiArtikal(ArtikalPK artikal_id);

	// uradjeno u res
	public Artikal ubaciArtikal(Artikal a);

	//// uradjeno u res
	public Korisnik napraviKorisnika(Korisnik k);

	// uradjeno u res
	public Narudzbenica napraviNarudzbenicu(Narudzbenica n);

	// uradjeno u res
	public Narudzbenica vratiNarudzbenicu(Long nar_id);
}
