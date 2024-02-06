package com.example.testProject.dto;

import com.example.testProject.entity.Author;
import com.example.testProject.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {

    private String isbn;

    private Category category;

    private String title;

    private Author author;

    private int rate;
}
