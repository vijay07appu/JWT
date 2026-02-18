package com.jwt.JWT.controllers;

import com.jwt.JWT.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @PostMapping("public/auth/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return null;
    }
}
