package com.first.ramSirRstApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.first.ramSirRstApi.security.CustomUserDetailService;

@Configuration
@EnableMethodSecurity //if i want to use roles for certain methods using this we can use two annotation " @PreAuthorize("hasRole('ADMIN')") and @PostAuthorize("hasRole('ADMIN')") "   in controller so that method can use by admin
public class SecurityConfig {

	//@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	
	
	public SecurityConfig(CustomUserDetailService customUserDetailService) {
		super();
		this.customUserDetailService = customUserDetailService;
	}
	


	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		//if any other application try to access by mimicking the url this will handle 
		//here we are turning off this feature
		http.csrf((csrf)->csrf.disable())
		//.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
		.authorizeHttpRequests((authorize)->authorize.requestMatchers(HttpMethod.GET ,"/api/*").permitAll().anyRequest().authenticated())
		                //it is permitted to all no authentication till here ( /api/* ) with GET
		                  //leaving this for every thing it need to authenticated
		                                          
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
    //static users	
	//matches the user and password from postman to the "users from here (adil,admin)"
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails adil=User.builder()
//				.username("adil")
//				.password(passwordEncoder().encode("adil"))
//				.roles("USER")
//				.build();
//		
//		UserDetails admin=User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(adil,admin);
//	}
	
	
	//@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
		
	}
}
