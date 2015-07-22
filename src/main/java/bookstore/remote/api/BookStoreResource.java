package bookstore.remote.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Artikal;
import bookstore.model.Autor;
import bookstore.model.Izdavac;
import bookstore.model.Knjiga;
import bookstore.model.Korisnik;
import bookstore.model.Narudzbenica;
import bookstore.services.BookStoreService;

@RestController
@RequestMapping(value = "/bookStoreService")
public class BookStoreResource {
	Logger logger = LoggerFactory.getLogger(BookStoreResource.class);
	protected BookStoreService bookStoreService;

	// BookStore API

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Autor> vratiSveAutore() {
		return bookStoreService.vratiSveAutore();
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Izdavac> vratiSveIzdavace() {
		return bookStoreService.vratiSveIzdavace();
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Knjiga unesiKnjigu(@RequestBody Knjiga k) {
		return bookStoreService.unesiNovuKnjigu(k);

	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Artikal ubaciArtikal(@RequestBody Artikal a) {

		return bookStoreService.ubaciArtikal(a);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Korisnik napraviKorisnika(@RequestBody Korisnik k) {

		return bookStoreService.napraviKorisnika(k);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Narudzbenica napraviNarudzbenicu(@RequestBody Narudzbenica n) {

		return bookStoreService.napraviNarudzbenicu(n);
	}

	// setteri i getteri
	public BookStoreService getBookStoreService() {
		return bookStoreService;
	}

	public void setBookStoreService(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}

}
