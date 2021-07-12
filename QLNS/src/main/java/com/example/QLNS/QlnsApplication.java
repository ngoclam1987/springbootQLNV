package com.example.QLNS;

import com.example.QLNS.security.SpringSecurityAuditorAware;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class QlnsApplication implements CommandLineRunner {


	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
	public static void main(String[] args) {
		SpringApplication.run(QlnsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Success");
	}
}

