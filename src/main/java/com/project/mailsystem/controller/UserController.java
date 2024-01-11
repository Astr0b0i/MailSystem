package com.project.mailsystem.controller;

import com.project.mailsystem.services.UserService;
import com.project.mailsystem.viewmodels.request.CreateUserRequest;
import com.project.mailsystem.viewmodels.response.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){
        CreateUserResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public String createUser(){
        return "endpoint a securizar";
    }
}
