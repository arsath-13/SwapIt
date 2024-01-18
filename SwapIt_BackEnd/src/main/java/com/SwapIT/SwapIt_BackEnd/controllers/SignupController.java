package com.SwapIT.SwapIt_BackEnd.controllers;

import com.SwapIT.SwapIt_BackEnd.dto.SignupDto;
import com.SwapIT.SwapIt_BackEnd.dto.UserDto;
import com.SwapIT.SwapIt_BackEnd.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> SignupUser(@RequestBody SignupDto signupDto) {
        UserDto createdUser = userService.createUser(signupDto);
        if (createdUser == null) {
            return new ResponseEntity<>("User not created. Come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
}
