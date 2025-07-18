package com.hibernate_spring_data_jpa.demo_jpa.bootstrap;

import com.hibernate_spring_data_jpa.demo_jpa.domain.BookEntity;
import com.hibernate_spring_data_jpa.demo_jpa.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Creazione del primo libro
        BookEntity bookDDD = new BookEntity("Domain Driven Design", "123", "RandomHouse");
        System.out.println("Id prima del salvataggio: " + bookDDD.getId()); // null

        // Salvataggio nel database
        BookEntity savedDDD = bookRepository.save(bookDDD);
        System.out.println("Id dopo il salvataggio: " + savedDDD.getId()); // 1

        // Creazione e salvataggio del secondo libro
        BookEntity bookSIA = new BookEntity("Spring In Action", "234234", "O'Reilly");
        BookEntity savedSIA = bookRepository.save(bookSIA);
        System.out.println("Secondo libro salvato con id: " + savedSIA.getId()); // 2

        // Stampa tutti i libri dal database
        System.out.println("\n=== ELENCO TUTTI I LIBRI ===");
        bookRepository.findAll().forEach(bookEntity -> {  // SENZA tipo esplicito
            System.out.println("Book Id: " + bookEntity.getId());
            System.out.println("Book Title: " + bookEntity.getTitle());
            System.out.println("Book ISBN: " + bookEntity.getIsbn());
            System.out.println("Book Publisher: " + bookEntity.getPublisher());
            System.out.println("---");
        });

        // Stampa il numero totale di libri
        System.out.println("Numero totale di libri: " + bookRepository.count());
    }
}