package com.coderoom.cashapp.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PutMapping("/registration")
    public ResponseEntity<UserAccount> registerUser(@Valid @RequestBody UserForm userRegistrationRequest){
        return new ResponseEntity<>(userService.registerUser(userRegistrationRequest) , HttpStatus.CREATED);
    }
}
