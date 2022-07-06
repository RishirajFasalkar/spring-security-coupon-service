package com.rishi.coupon.service.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rishi.coupon.service.security.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		//Imp note: ROLE_ is inserted by spring. In DB we have to maintain ROLE_USER, ROLE_ADMIN etc.
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/couponapi/coupon").hasAnyRole("USER", "ADMIN")
		.mvcMatchers(HttpMethod.POST, "/couponapi/coupon").hasRole("ADMIN")
		.and().csrf().disable();// to be able to use post method from postman
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
