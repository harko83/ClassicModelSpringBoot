package org.vladirius.classicmodel.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "BOW";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(rawPassword);
		System.out.println(encodedPassword);
		System.out.println(encoder.matches(rawPassword, encodedPassword));
	}

}
