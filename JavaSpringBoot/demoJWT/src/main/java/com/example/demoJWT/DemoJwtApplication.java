package com.example.demoJWT;

import com.example.demoJWT.entity.User;
import com.example.demoJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoJwtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJwtApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("username");
		user.setPassword(passwordEncoder.encode("123"));
		userRepository.save(user);
		System.out.println(user);
	}
}
