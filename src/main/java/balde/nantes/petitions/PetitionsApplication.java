package balde.nantes.petitions;

import balde.nantes.petitions.entities.Petition;
import balde.nantes.petitions.repositories.PetitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PetitionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetitionsApplication.class, args);
	}

}
