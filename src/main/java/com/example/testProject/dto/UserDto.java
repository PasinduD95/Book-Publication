package com.example.testProject.dto;

import com.example.testProject.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private long id;

    private String firstName;

    private String lastName;

    private String contactNo;

    private String email;

    private Set<Book> likedBooks;
}
