package com.example.testProject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToMany(mappedBy = "likedBooks")
    private Set<User> user;

}
