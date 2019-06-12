package com.example.demoproject.repository;

import com.example.demoproject.model.UserAccount;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import static org.junit.Assert.*;

@SpringBootTest(properties = {"spring.datasource.url=jdbc:mysql://localhost:3306/mobile_operator_test_DB?useSSL=false&createDatabaseIfNotExist=true",
        "spring.datasource.initialization-mode=never"})
@RunWith(SpringRunner.class)
public class UserAccountRepositoryTest {
    @Autowired
    private UserAccountRepository userAccountRepository;
    private UserAccount validAccount;
    private UserAccount invalidAccount;
    private UserAccount invalidAccount2;

    @Before
    public void init(){
        validAccount = new UserAccount(1,"John Jonson", LocalDate.of(2014,3,23),"2",null,null);
        invalidAccount = new UserAccount(2, null, LocalDate.of(2011,4,12), "1",null,null);
        invalidAccount2 = new UserAccount(2, "ASD", LocalDate.of(2011,4,12), "12",null,null);
    }


    @Test
    public void shouldSaveValidAccount(){
        UserAccount saved = userAccountRepository.save(validAccount);

        assertEquals(validAccount,saved);
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotSaveInvalidAccount(){
        userAccountRepository.save(invalidAccount);
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void genderPatternTest(){
        userAccountRepository.save(invalidAccount2);
    }
}
