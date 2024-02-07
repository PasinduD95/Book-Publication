package com.example.testProject.service;

import com.example.testProject.dto.UserDto;
import com.example.testProject.entity.User;
import com.example.testProject.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserDto saveUser(UserDto userDto) {
        try {
            User existUser = userRepo.getUserByEmail(userDto.getEmail());
            if (existUser == null) {
                userRepo.save(modelMapper.map(userDto, User.class));
                logger.info("Successfully saved a new user. {}", userDto.getId());
            } else {
                logger.info("User is exist. {}", userDto.getId());
            }
        } catch (Exception e) {
            logger.debug("Exception occured when saving a user : {}", e.getMessage());
        }
        return userDto;
    }

}
