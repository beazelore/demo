package com.softserve.demoproject.controller;

import com.softserve.demoproject.model.UserAccount;
import com.softserve.demoproject.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
