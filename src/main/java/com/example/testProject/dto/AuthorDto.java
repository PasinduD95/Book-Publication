package com.example.testProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
}
