package com.example.testProject.repo;

import com.example.testProject.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

    @Query(value = "select * from author where email = ?1", nativeQuery = true)
    Author getAuthorByEmail(String email);

}
