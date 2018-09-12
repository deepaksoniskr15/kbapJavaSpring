package com.lina.chat.app.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lina.chat.app.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService userDetailsService;

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests().antMatchers("/api/login", "/api/403").permitAll();
		http.authorizeRequests().antMatchers("/**").access("hasRole('ROLE_USER')");
		http.authorizeRequests().and().formLogin().loginPage("/api/login").failureUrl("/api/403")
				.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/api/signin");
	}

	@Bean
	public AuthenticationProvider daoAuthenticationProvider() {
		System.out.println(new BCryptPasswordEncoder().encode("testuser"));
		DaoAuthenticationProvider impl = new DaoAuthenticationProvider();
		impl.setUserDetailsService(userDetailsService);
		impl.setPasswordEncoder(new BCryptPasswordEncoder());
		impl.setHideUserNotFoundExceptions(false);
		return impl;
	}

}