package org.gilsid.keynote;

import org.gilsid.keynote.dao.entities.Keynote;
import org.gilsid.keynote.dao.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class KeynoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            KeynoteRepository keynoteRepository) {
        return args -> {
            keynoteRepository.save(new Keynote(null, "James", "Gosling", "Java", "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible."));
            keynoteRepository.save(new Keynote(null, "Guido", "van Rossum", "Python", "Python is an interpreted, high-level and general-purpose programming language."));
            keynoteRepository.save(new Keynote(null, "Yukihiro", "Matsumoto", "Ruby", "Ruby is an open-source and fully object-oriented programming language."));

        };

    }



}
