package com.example.testProject.repo;

import com.example.testProject.dto.AuthorLikeDto;
import com.example.testProject.entity.Author;
import com.example.testProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {

    @Query(value = "select * from book where authorId = ?1", nativeQuery = true)
    Book findByAuthorId(String email);

    @Query(value = "select *, count(user_id) from user_like left join book on user_like.book_id=book.isbn group by author_id", nativeQuery = true)
    List<Object> countLikesByAuthor();

    @Query(value = "select count(user_id) from user_like where book_id = ?1", nativeQuery = true)
    Integer countLikesByIsbn(String isbn);



}
