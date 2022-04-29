package com.avisrini.hellosb.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student jack = new Student(1L, "Jack", "jack@b.c", LocalDate.of(2000, 6, 10));
			Student jones = new Student(2L, "Jones", "jones@b.c", LocalDate.of(2001, 5, 13));
			
			repository.saveAll(List.of(jack, jones));
		};
		
	}
}
