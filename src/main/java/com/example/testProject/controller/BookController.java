package com.example.testProject.controller;

import com.example.testProject.dto.BookDto;
import com.example.testProject.entity.Book;
import com.example.testProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }

//    @PostMapping("/like")
//    public int ratingBook(@RequestParam("isbn") String isbn) {
//        return bookService.ratingBook(isbn);
//    }

    @GetMapping("/search")
    public BookDto searchBook(@RequestParam("isbn") String isbn) {
        return bookService.searchBook(isbn);
    }
}
