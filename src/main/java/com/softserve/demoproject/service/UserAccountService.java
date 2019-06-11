package com.softserve.demoproject.service;

import com.softserve.demoproject.model.PhoneNumber;
import com.softserve.demoproject.model.UserAccount;
import com.softserve.demoproject.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository){
        this.userAccountRepository = userAccountRepository;
    }
    public UserAccount addUser(UserAccount userAccount){
        for (PhoneNumber p : userAccount.getPhones()){
            p.setOwnedBy(userAccount);
        }
        return userAccountRepository.save(userAccount);
    }

    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }
}
