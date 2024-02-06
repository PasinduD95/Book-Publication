package com.example.testProject.controller;

import com.example.testProject.dto.AuthorDto;
import com.example.testProject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public AuthorDto saveNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.saveAuthor(authorDto);
    }
}
