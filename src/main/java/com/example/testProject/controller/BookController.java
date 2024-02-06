package com.example.testProject.controller;

import com.example.testProject.dto.BookDto;
import com.example.testProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }
}
