package com.example.demoproject.service;

import com.example.demoproject.model.PhoneNumber;
import com.example.demoproject.model.UserAccount;
import com.example.demoproject.repository.UserAccountRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserAccountService {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository){
        this.userAccountRepository = userAccountRepository;
    }
    public UserAccount addUser(UserAccount userAccount){
        for (PhoneNumber p : userAccount.getPhones()){
            p.setOwnedBy(userAccount);
        }
        return userAccountRepository.save(userAccount);
    }
}
