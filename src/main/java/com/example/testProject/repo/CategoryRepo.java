package com.example.testProject.repo;

import com.example.testProject.entity.Author;
import com.example.testProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = "select * from category where name = ?1", nativeQuery = true)
    Category getCategoryByName(String name);
}
