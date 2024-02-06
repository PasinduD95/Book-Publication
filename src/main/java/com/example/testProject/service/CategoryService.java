package com.example.testProject.service;

import com.example.testProject.dto.BookDto;
import com.example.testProject.dto.CategoryDto;
import com.example.testProject.entity.Book;
import com.example.testProject.entity.Category;
import com.example.testProject.repo.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        try {
            Optional<Category> existCategory = categoryRepo.findById(categoryDto.getId());
            if (existCategory.isEmpty()) {
                categoryRepo.save(modelMapper.map(categoryDto, Category.class));
                logger.info("Successfully saved a new category. {}", categoryDto.getName());
            } else {
                logger.info("This category is exist. {}", categoryDto.getName());
            }
        } catch (Exception e) {
            logger.debug("Exception occured when saving a new category : {}", e.getMessage());
        }
        return categoryDto;
    }
}
