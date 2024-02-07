package com.example.testProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorLikeDto {

    private long userId;
    private long bookId;
    private String isbn;
    private String title;
    private long authorId;
    private long categoryId;
    private long count;

}
