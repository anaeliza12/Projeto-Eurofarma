package com.eurofarma.euforma.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.eurofarma.euforma.security.jwt.TokenFilter;
import com.eurofarma.euforma.security.jwt.TokenProvider;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 TokenFilter customFilter = new TokenFilter(tokenProvider);
		    return http
		        .httpBasic(basic -> basic.disable())
		        .csrf(csrf -> csrf.disable())
		        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		        .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
		        .authorizeHttpRequests(auth -> 
		            auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/auth/refresh/**",
		                    "/api-docs/**", "/auth/signin").permitAll()		
			            .requestMatchers("eurofarma/admin/**").hasRole("ADMIN")
			            .requestMatchers("eurofarma/user/**").hasRole("USER")
		                .requestMatchers("/users").denyAll())		
		        .cors(cors -> {})
		        .build();		
	}
}
