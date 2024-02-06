package com.example.testProject.repo;

import com.example.testProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, String> {
}
