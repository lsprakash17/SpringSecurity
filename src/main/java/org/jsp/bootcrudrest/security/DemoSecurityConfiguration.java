package org.jsp.bootcrudrest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager detailsManager() {

		UserDetails principle = User.builder().username("prakash").password("{noop}1234").roles("principal").build();
		UserDetails Lecturer = User.builder().username("akash").password("{noop}121").roles("lecturer").build();
		return new InMemoryUserDetailsManager(principle, Lecturer);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(
				configurer -> configurer.requestMatchers(HttpMethod.GET, "/api/students/all").hasRole("principal")
				.requestMatchers(HttpMethod.GET, "/api/students").hasRole("principal")

		);

//	using http basic authentication
		httpSecurity.httpBasic();
//in general,not require for stateless Rest Api's That uses Post,put,delete, and patch
		httpSecurity.csrf().disable();
		return httpSecurity.build();
	}

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(configure->
		
				configure.requestMatchers(HttpMethod.GET,"/api/students").hasRole("manager"));
		
				http.httpBasic();
				http.csrf().disable();
				return http.build();
	}
	

}
