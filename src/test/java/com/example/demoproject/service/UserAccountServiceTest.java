package com.example.demoproject.service;

import com.example.demoproject.model.PhoneNumber;
import com.example.demoproject.model.UserAccount;
import com.example.demoproject.repository.UserAccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserAccountServiceTest {
    @TestConfiguration
    static class UserAccountServiceTestContextConfiguration {

        @Bean
        public UserAccountService userAccountService() {
            return new UserAccountService();
        }
    }

    @InjectMocks
    private UserAccountService userAccountService;

    @Mock
    private UserAccountRepository userAccountRepository;

    private UserAccount userAccount = new UserAccount(1,"John Doe",  LocalDate.now(),"1", null, null);
    private final PhoneNumber phone = new PhoneNumber(1,"234-523532-253523", null);

    @Before
    public void init(){
        userAccount.setPhones(Set.of(phone));

        Mockito.when(userAccountRepository.save(any(UserAccount.class))).thenReturn(userAccount);
    }

    @Test
    public void saveAccountTest(){
        UserAccount result = userAccountRepository.save(userAccount);

        assertEquals(result, userAccount);
        assertTrue(result.getPhones().contains(phone));

    }
}
