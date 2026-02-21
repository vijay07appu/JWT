package com.jwt.JWT.controllers;

import com.jwt.JWT.dto.UserRequestDTO;
import com.jwt.JWT.dto.UserResponseDTO;
import com.jwt.JWT.entity.User;
import com.jwt.JWT.mapper.Mapper;
import com.jwt.JWT.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Mapper mapper;
    @Autowired
    private UserResponseDTO userResponseDTO;


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO =userService.register(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
        
    }
}
