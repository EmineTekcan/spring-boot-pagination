package com.projects.springbootpagination.repository;

import com.projects.springbootpagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
