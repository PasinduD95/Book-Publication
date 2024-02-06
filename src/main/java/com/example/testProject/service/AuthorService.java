package com.example.testProject.service;

import com.example.testProject.dto.AuthorDto;
import com.example.testProject.entity.Author;
import com.example.testProject.repo.AuthorRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public AuthorDto saveAuthor(AuthorDto authorDto) {
        try {
            Author existAuthor = authorRepo.getAuthorByEmail(authorDto.getEmail());
            if (existAuthor == null) {
                authorRepo.save(modelMapper.map(authorDto, Author.class));
                logger.info("Successfully saved a new author. {}", authorDto.getId());
            } else {
                logger.info("Author is exist. {}", authorDto.getId());
            }
        } catch (Exception e) {
            logger.debug("Exception occured when saving an author : {}", e.getMessage());
        }
        return authorDto;
    }
}
