package com.hibernate_spring_data_jpa.demo_jpa.repositories;

import com.hibernate_spring_data_jpa.demo_jpa.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
