package com.softserve.demoproject.controller;

import com.softserve.demoproject.model.UserAccount;
import com.softserve.demoproject.service.UserAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
public class UserAccountController {

    private UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService){
        this.userAccountService = userAccountService;
    }
    @PostMapping
    public UserAccount addUser(@RequestBody UserAccount userAccount){
        return userAccountService.addUser(userAccount);
    }

    @GetMapping
    public List<UserAccount> getAll(){
        return userAccountService.getAll();
    }
}
