package bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Chris on 10/26/14.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthFailure authFailure;

	@Autowired
	private AuthSuccess authSuccess;

	@Autowired
	private EntryPointUnauthorizedHandler unauthorizedHandler;

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Autowired
	public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailService);
	}

	@Override

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/lib/**", "/app/**"); // #3
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.csrf().disable().authorizeRequests().antMatchers("/", "/signin", "/korisnici").permitAll() // #4
		// .antMatchers("/knjige").hasRole("USER") // #6
		// .antMatchers("/admin/**").hasRole("ADMIN") // #6
		// .anyRequest().authenticated() // 7
		// .and().formLogin() // #8
		// .permitAll() // #5
		// ;

		// OD Chrisa
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().formLogin()
				.successHandler(authSuccess).failureHandler(authFailure).and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("JSESSIONID")
				.invalidateHttpSession(true).and().authorizeRequests().antMatchers("/", "/login", "/register")
				.permitAll().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
				.antMatchers("/knjige/**").hasRole("USER").anyRequest().authenticated();

	}
}
