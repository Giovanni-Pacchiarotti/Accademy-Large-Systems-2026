package com.academy.secondo_progetto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.academy.secondo_progetto.entities.Studente;
import com.academy.secondo_progetto.repositories.StudenteRepository;

@Configuration
public class TestCRUDConfig 
{

    @Bean
    CommandLineRunner testCRUD(StudenteRepository repository) 
    {
        return args -> 
        {

            System.out.println("=== CREAZIONE STUDENTI ===");

            Studente s1 = new Studente();
            s1.setNome("Mario");
            s1.setCognome("Rossi");
            s1.setEmail("mario@email.com");
            s1.setDataNascita(LocalDate.of(2000, 1, 10));
            s1.setCorsoLaurea("Informatica");

            Studente s2 = new Studente();
            s2.setNome("Luigi");
            s2.setCognome("Verdi");
            s2.setEmail("luigi@email.com");
            s2.setDataNascita(LocalDate.of(1999, 5, 20));
            s2.setCorsoLaurea("Matematica");

            Studente s3 = new Studente();
            s3.setNome("Anna");
            s3.setCognome("Bianchi");
            s3.setEmail("anna@email.com");
            s3.setDataNascita(LocalDate.of(2001, 3, 15));
            s3.setCorsoLaurea("Informatica");

            repository.save(s1);
            repository.save(s2);
            repository.save(s3);

            System.out.println("\n=== TUTTI GLI STUDENTI ===");
            List<Studente> tutti = repository.findAll();
            tutti.forEach(s -> System.out.println(s.getId() + " " + s.getNome() + " " + s.getCorsoLaurea()));

            System.out.println("\n=== UPDATE PRIMO STUDENTE ===");
            Studente primo = repository.findById(s1.getId()).orElseThrow();
            primo.setCorsoLaurea("Fisica");
            repository.save(primo);

            System.out.println("Aggiornato: " + primo.getNome() + " -> " + primo.getCorsoLaurea());

            System.out.println("\n=== DELETE TERZO STUDENTE ===");
            repository.deleteById(s3.getId());
            System.out.println("Eliminato studente con ID: " + s3.getId());

            System.out.println("\n=== QUERY PER CORSO (Informatica) ===");
            List<Studente> informatici = repository.findByCorsoLaurea("Informatica");
            informatici.forEach(s -> System.out.println(s.getNome() + " " + s.getCognome()));

            System.out.println("\n=== STATO FINALE DB ===");
            repository.findAll()
                      .forEach(s -> System.out.println(s.getId() + " " + s.getNome() + " " + s.getCorsoLaurea()));
        };
    }
}