package com.eurofarma.euforma.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.eurofarma.euforma.security.jwt.JwtTokenFilter;
import com.eurofarma.euforma.security.jwt.TokenProvider;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Autowired
	private TokenProvider tokenProvider;

	@Bean
	public PasswordEncoder passwordEnconder() {
		Map<String, PasswordEncoder> enconders = new HashMap<>();
		Pbkdf2PasswordEncoder pbkdf2Enconder = new Pbkdf2PasswordEncoder("", 8, 185000,
				SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

		enconders.put("pbkdf2", pbkdf2Enconder);
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", enconders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Enconder);

 		return passwordEncoder;
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
    		throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		JwtTokenFilter customFilter = new JwtTokenFilter(tokenProvider);
		return http
		.httpBasic(basic -> basic.disable())
		.csrf(csrf -> csrf.disable())
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
		.authorizeHttpRequests(auth -> 
		auth.requestMatchers("/swagger-ui/**","/v3/api-docs/**", "/api-eurofarma/auth/v1/refresh/**",
				"/api-docs/**", "/api-eurofarma/auth/v1/login").permitAll()		
				.requestMatchers("/api/**").authenticated() 
				.requestMatchers("/users").denyAll())
				.cors(cors -> {})
				.build();
	}

}
