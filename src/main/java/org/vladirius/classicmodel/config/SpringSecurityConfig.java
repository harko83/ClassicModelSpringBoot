package org.vladirius.classicmodel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.vladirius.classicmodel.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Gestion des exceptions
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	/*
	 * Hashage du mot de passe
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * Validation du token d'identification
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	/*
	 * Cette méthode va gérer les accès aux différentes URL
	 * selon que le visiteur soit connecté ou non
	 * selon le role du profil connecté
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http	
	        .cors()
			.disable()
			.csrf()
//	            .csrfTokenRepository(this.csrfTokenRepository())
			.disable()
//	        .and()
			.authorizeRequests()
			.antMatchers("/favicon.ico", "/js/*", "/css/*", "/img/**", "/fonts/*").permitAll()
			.antMatchers("/", "/contact", "/contact/*", "/login", "/products", "/products/*").permitAll()
			.antMatchers("/employees/global").hasAuthority("ADMIN")
			.antMatchers("/employees/manager").hasAuthority("SUPEREMPLOYEE")
			.antMatchers("/client/cart").hasAnyAuthority("CLIENT")
			.anyRequest().authenticated()
	        .and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("login")
			.passwordParameter("pass")
			.defaultSuccessUrl("/")
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.and()
			.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler)
			.and()
			.httpBasic();
    }
}
