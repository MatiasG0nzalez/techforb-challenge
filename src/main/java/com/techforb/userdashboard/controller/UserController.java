package com.techforb.userdashboard.controller;

import com.techforb.userdashboard.dto.UserDTO;
import com.techforb.userdashboard.dto.UserRegisterDTO;
import com.techforb.userdashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/auth")
    public ResponseEntity<?> getAuthUser(Authentication auth){
        UserDTO userDTO = userService.getAuthUser(auth);
        return ResponseEntity.ok(userDTO);
    }





    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserRegisterDTO user){

        return userService.createUser(user);

    }





}
