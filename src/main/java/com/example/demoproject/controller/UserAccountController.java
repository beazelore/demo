package com.example.demoproject.controller;

import com.example.demoproject.model.UserAccount;
import com.example.demoproject.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    private UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService){
        this.userAccountService = userAccountService;
    }
    @PostMapping
    public UserAccount addUser(@RequestBody UserAccount userAccount){
        return userAccountService.addUser(userAccount);
    }

}
