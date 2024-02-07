package com.example.testProject.service;

import com.example.testProject.dto.BookDto;
import com.example.testProject.entity.Book;
import com.example.testProject.entity.User;
import com.example.testProject.repo.BookRepo;
//import com.example.testProject.repo.UserRepo;
import com.example.testProject.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@Configuration
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookDto saveBook(BookDto bookDto) {
        try {
            Optional<Book> existBook = bookRepo.findById(bookDto.getIsbn());
            if (bookDto.getAuthor().getEmail() == null) {
                logger.error("The system doesn’t allow a book to exist without an author.");
            }
            else if (existBook.isEmpty()) {
                bookRepo.save(modelMapper.map(bookDto, Book.class));
                logger.info("Successfully saved a new book. {}", bookDto.getIsbn());
            } else {
                logger.info("Book is exist. {}", bookDto.getIsbn());
            }
        } catch (Exception e) {
            logger.debug("Exception occured when saving a new book : {}", e.getMessage());
        }
        return bookDto;
    }

    public int ratingBooks(String isbn) {
        int count = 0;
        try {
            count = bookRepo.countLikesByIsbn(isbn);
            logger.info("Total likes of book {} : {}", isbn, count);

        } catch (Exception e) {
            logger.debug("Exception occured countLikesByIsbn()  : {}", e.getMessage());
        }
        return count;
    }

    public BookDto searchBook(String isbn) {
        Book book = bookRepo.findById(isbn).orElseThrow();
        logger.info("The Book found : Title is {} ", book.getTitle());
        return modelMapper.map(book, BookDto.class);

    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void autoGenerateAuthorLike(){
        try {
            List<Object> authorLike = bookRepo.countLikesByAuthor();
            for (int i=0; i<authorLike.size(); i++) {
                Object[] obj = (Object[]) authorLike.get(i);
                logger.info("The autherId : {} | Likes : {} ", String.valueOf(obj[4]), String.valueOf(obj[6]));
            }

        } catch (Exception e) {
            logger.debug("Exception occured in countLikesByAuthor() : {}", e.getMessage());
        }
    }

}
