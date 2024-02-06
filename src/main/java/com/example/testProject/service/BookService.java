package com.example.testProject.service;

import com.example.testProject.dto.AuthorDto;
import com.example.testProject.dto.BookDto;
import com.example.testProject.entity.Author;
import com.example.testProject.entity.Book;
import com.example.testProject.repo.AuthorRepo;
import com.example.testProject.repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookDto saveBook(BookDto bookDto) {
        try {
            Optional<Book> existBook = bookRepo.findById(bookDto.getIsbn());
            if (existBook.isEmpty()) {
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

//    public BookDto ratingBook(String isbn) {
//        try {
//            Optional<Book> book = bookRepo.findById(isbn);
//            if (existBook.isEmpty()) {
//                bookRepo.save(modelMapper.map(bookDto, Book.class));
//                logger.info("Successfully saved a new book. {}", bookDto.getIsbn());
//            } else {
//                logger.info("Book is exist. {}", bookDto.getIsbn());
//            }
//        } catch (Exception e) {
//            logger.debug("Exception occured when saving a new book : {}", e.getMessage());
//        }
//        return bookDto;
//    }

    public BookDto searchBook(String isbn) {
        Optional<Book> book = Optional.of(new Book());
        try {
            book = bookRepo.findById(isbn);
        } catch (Exception e) {
            logger.debug("Exception occured when getting a book : {}", e.getMessage());
        }
        return modelMapper.map(book, BookDto.class);
    }
}
