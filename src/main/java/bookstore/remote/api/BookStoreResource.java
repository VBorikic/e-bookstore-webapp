package bookstore.remote.api;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Artikal;
import bookstore.model.ArtikalPK;
import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Narudzbenica;
import bookstore.services.BookStoreService;

@RestController
public class BookStoreResource {
	Logger logger = LoggerFactory.getLogger(BookStoreResource.class);

	protected BookStoreService bookStoreService;

	// BookStore API

	@RequestMapping(value = "/autori", method = RequestMethod.GET)
	public @ResponseBody List<Autor> vratiSveAutore() {
		return bookStoreService.vratiSveAutore();
	}

	@RequestMapping(value = "/izdavaci", method = RequestMethod.GET)
	public @ResponseBody List<Izdavac> vratiSveIzdavace() {
		return bookStoreService.vratiSveIzdavace();
	}

	@RequestMapping(value = "/narudzbenice", method = RequestMethod.POST)
	public @ResponseBody void kreirajNarudzbenicu(@RequestBody List<Artikal> listaArtikala) {
		// TODO kreirati narudbenicu i sacuvati u bazu
		Narudzbenica n = bookStoreService.napraviNarudzbenicu(new Narudzbenica());
		double ukupnaCena = 0.0;
		for (int i = 0; i < listaArtikala.size(); i++) {

			Artikal artikal = listaArtikala.get(i);
			ukupnaCena += artikal.getBrojKupljenihKnjiga() * artikal.getKnjiga().getCena();

			ArtikalPK apk = new ArtikalPK(n.getNarudzbenicaID(), artikal.getKnjiga().getISBN());
			apk.setArtikalId(Long.valueOf(i + 1));

			artikal.setNarudzbenica(n);
			artikal.setArtikalPK(apk);
		}
		n.setSumaCene(ukupnaCena);
		n.setListaArtikala(listaArtikala);
		n.setDatum(new Date());
		bookStoreService.sacuvajNarudzbenicu(n);
		// System.out.println("Stigli artikli");
	}

	@RequestMapping(value = "/narudzbenice", method = RequestMethod.GET)
	public @ResponseBody List<Narudzbenica> vratiSveNarudzbenice() {
		return bookStoreService.vratiSveNarudzbenice();
	}
	//
	// @RequestMapping(method = RequestMethod.POST)
	// public @ResponseBody Artikal ubaciArtikal(@RequestBody Artikal a) {
	//
	// return bookStoreService.ubaciArtikal(a);
	// }
	//
	// @RequestMapping(method = RequestMethod.POST)
	// public @ResponseBody Korisnik napraviKorisnika(@RequestBody Korisnik k) {
	//
	// return bookStoreService.napraviKorisnika(k);
	// }
	//
	// @RequestMapping(method = RequestMethod.POST)
	// public @ResponseBody Narudzbenica napraviNarudzbenicu(@RequestBody Narudzbenica n) {
	//
	// return bookStoreService.napraviNarudzbenicu(n);
	// }
	//
	// @RequestMapping(value = "/{narudzbenicaID}/data", method = RequestMethod.GET)
	// public @ResponseBody Narudzbenica vratinarudzbenicu(@PathVariable("narudzbenicaID") Long nar_id) {
	// return bookStoreService.vratiNarudzbenicu(nar_id);
	// }
	//
	// @RequestMapping(value = "/{artikalId}/data", method = RequestMethod.GET)
	// public @ResponseBody Artikal vratiArtikal(@PathVariable("artikalId") ArtikalPK artikal_id) {
	// return bookStoreService.vratiArtikal(artikal_id);
	// }

	// setteri i getteri
	public BookStoreService getBookStoreService() {
		return bookStoreService;
	}

	public void setBookStoreService(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}

}
