package bookstore.remote.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Korisnik;
import bookstore.services.KorisnikService;
import bookstore.services.UserService;

@RestController
@Service
public class KorisnikResource {

	Logger logger = LoggerFactory.getLogger(KnjigaResource.class);

	@Autowired
	protected KorisnikService korisnikService;

	// @Autowired
	protected UserService userService;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping(value = "/korisnici", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	public @ResponseBody List<Korisnik> getAllKorisnici() {
		return korisnikService.vratiSveKorisnike();
	}

	@RequestMapping(value = "/registracija", method = RequestMethod.POST)
	@PreAuthorize("permitAll")
	public @ResponseBody Korisnik napraviKorisnika(@RequestBody Korisnik korisnik) {
		Korisnik k = userService.napraviNovogKorisnika(korisnik);

		// send mail
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo(k.getMail());
		msg.setFrom("vlada.borikic@gmail.com");
		msg.setSubject("Dobrodosli!");
		msg.setText("Dragi " + k.getIme() + " " + k.getPrezime()

		+ ",\nHvala vam na registraciji u nasu knjizaru. " + "Nadamo se da cete biti zadovoljni nasim knjigama :)"
				+ "\n\nKnowledge Limited Tim ");
		try {
			mailSender.send(msg);
		}
		catch (Exception ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
		return k;
	}

	@RequestMapping(value = "/korisnici/{username}", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	public @ResponseBody Korisnik vratiKorisnika(@PathVariable("username") String username) {

		return userService.pronadjiKorisnikaPoKorisnickomImenu(username);
	}

	public KorisnikService getKorisnikService() {
		return korisnikService;
	}

	public void setKorisnikService(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
}
