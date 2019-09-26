package fr.move.in.med.medicApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "fr.move.in.med")
public class MedicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicAppApplication.class, args);
	}

}
