package bookstore.remote.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Korisnik;
import bookstore.services.KorisnikService;

@RestController
public class KorisnikResource {

	Logger logger = LoggerFactory.getLogger(KnjigaResource.class);

	protected KorisnikService korisnikService;

	@RequestMapping(value = "/korisnici", method = RequestMethod.POST)
	public @ResponseBody Korisnik napraviKorisnika(@RequestBody Korisnik korisnik) {
		// blog.setCreated(new Date());
		// logger.debug("pravljenje korisnika");
		return korisnikService.napraviNovogKorisnika(korisnik);
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody Korisnik prijaviKorisnika(@RequestBody Korisnik korisnik) {

		return korisnikService.napraviNovogKorisnika(korisnik);
	}

	public KorisnikService getKorisnikService() {
		return korisnikService;
	}

	public void setKorisnikService(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}
}
