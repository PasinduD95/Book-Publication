package com.example.testProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "book")
public class Book {

    @Id
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Column(nullable=false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;

    private int rate;
}
