package com.hibernate_spring_data_jpa.demo_jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
/**
 * Entità JPA che rappresenta un libro nel database
 * Lombok genera automaticamente getter, setter, toString
 */
@Entity
@Table(name = "BookEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id; // Chiave primaria generata automaticamente

    @Column(nullable = false, length = 100)
    private String title;

    @Column(name = "isbn", length = 20)
    private String isbn;

    @Column(name = "publisher", length = 100)
    private String publisher;

    // Costruttore parametrico personalizzato senza id (per la creazione di nuovi oggetti)
    public BookEntity(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity bookEntity = (BookEntity) o;
        return Objects.equals(id, bookEntity.id);
    }

    @Override
    public int hashCode() {
        return id !=null ? id.hashCode() : 0;
    }
}