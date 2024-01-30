package com.fas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FptAttendanceSytemBeApplication {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String password1 = passwordEncoder.encode("123456");
		String password2 = passwordEncoder.encode("123456");
		String password3 = passwordEncoder.encode("123456");
		String password4 = passwordEncoder.encode("123456");

		SpringApplication.run(FptAttendanceSytemBeApplication.class, args);
	}

}
