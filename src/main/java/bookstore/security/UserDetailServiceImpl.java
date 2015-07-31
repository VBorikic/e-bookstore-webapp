package bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import bookstore.model.Korisnik;
import bookstore.services.KorisnikService;

/**
 * Created by Chris on 10/19/14.
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private KorisnikService service;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Korisnik korisnik = service.pronadjiKorisnikaPoKorisnickomImenu(name);
		if (korisnik == null) {
			throw new UsernameNotFoundException("no user found with " + name);
		}
		return new AccountUserDetails(korisnik);
	}
}
