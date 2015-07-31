package bookstore.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bookstore.model.Korisnik;

/**
 * Created by Chris on 10/19/14.
 */
public class AccountUserDetails implements UserDetails {

	// private final Account account;
	private final Korisnik korisnik;

	public AccountUserDetails(Korisnik account) {
		this.korisnik = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority authority = new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "USER";
			}
		};

		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return korisnik.getPassword();
	}

	@Override
	public String getUsername() {
		return korisnik.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
