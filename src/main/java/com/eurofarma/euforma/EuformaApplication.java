package com.eurofarma.euforma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EuformaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuformaApplication.class, args);
		
//		Map<String, PasswordEncoder> enconders = new HashMap<>();
//		Pbkdf2PasswordEncoder pbkdf2Enconder = new Pbkdf2PasswordEncoder("", 8, 185000,
//				SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
//
//		enconders.put("pbkdf2", pbkdf2Enconder);
//		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", enconders);
//		passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Enconder);
//
//		String result = passwordEncoder.encode("admin123");
//		System.out.println("HASH all" + result);

	}

}
