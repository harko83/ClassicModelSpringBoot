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

//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;
//	
//	/*
//	 * roles admin allow to access /admin/**
//	 * roles user allow to acces /user/**
//	 * custom 403 acces denied handler
//	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.csrf().disable()
//		.authorizeRequests()
//			.antMatchers("/","/home","/about").permitAll()
//			.antMatchers("/admin/**").hasAnyRole("ADMIN")
//			.and()
//			.formLogin()
//				.loginPage("/login") // Specifies the login page URL
//				.permitAll()
//				.and()
//				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//	}
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user").password("password").roles("USER")
//		.and()
//		.withUser("admin").password("password").roles("ADMIN");
//	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
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
	
	//V2
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests()
//			.antMatchers("/favicon.ico", "/js/*", "/css/*", "/img/**", "/fonts/*").permitAll()
//			.antMatchers("/","/contact","/products", "/products/*").anonymous()
////			.antMatchers("/").hasAnyAuthority("ADMIN", "EMPLOYEE", "SUPEREMPLOYEE", "CLIENT")
////			.antMatchers("/new").hasAnyAuthority("ADMIN", "SUPEREMPLOYEE", "EMPLOYEE")
////            .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "SUPEREMPLOYEE", "EMPLOYEE")
////            .antMatchers("/delete/**").hasAuthority("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//	            .loginPage("/login").permitAll()
////	            .usernameParameter("login")
////	            .passwordParameter("pass")
//	            .defaultSuccessUrl("/")
//            .and()
//            .logout().permitAll()
////          .logoutSuccessUrl("/logout")
//            .and()
//            .exceptionHandling().accessDeniedPage("/403")
//            ;
//	}
	
	//V3
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/","/index").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/login", "/resource/**","/").permitAll()
                .and()
          .formLogin().loginPage("/login").usernameParameter("login").passwordParameter("pass").permitAll()
                .loginProcessingUrl("/doLogin")
                .successForwardUrl("/postLogin")
                .failureUrl("/loginFailed")
                .and()
                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
                .and()
                .csrf().disable();
    }
}
