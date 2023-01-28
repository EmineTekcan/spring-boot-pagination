package com.projects.springbootpagination.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private LocalDate publishDate;
}
