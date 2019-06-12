package com.example.demoproject.repository;

import com.example.demoproject.model.Call;
import com.example.demoproject.model.UserAccount;
import com.example.demoproject.projection.CallStatistics;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.datasource.url=jdbc:mysql://localhost:3306/mobile_operator_test_DB?useSSL=false&createDatabaseIfNotExist=true",
        "spring.datasource.initialization-mode=never"})
public class CallRepositoryIntegrationTest {

    @Autowired
    private CallRepository callRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;

    private UserAccount userAccount;
    private Call callOne,callTwo;
    private LocalDateTime date1, date2;

    @Before
    public void init(){
        userAccount = new UserAccount(1L,"John Doe",  LocalDate.now(),"1", null, null);
        date1 = LocalDateTime.of(2006,4,25,21,41,6);
        date2 = LocalDateTime.of(2008,12,25,21,41,6);
        userAccountRepository.save(userAccount);
        callOne = new Call(1L,userAccount,"2412-541214-421","123-456-653",
                date1,888,"Kyiv");
        callTwo = new Call(2L,userAccount,"2412-541214-421","123-456-653",
                date2,111,"Kyiv");
        callRepository.save(callOne);
        callRepository.save(callTwo);

    }
    @Test
    public void getLongestCallForUserBetweenDates(){
        Call result = callRepository.getLongestCall(1L,"2005-01-01T11:11:11",LocalDate.now().toString()).get(0);

        assertEquals(result.getId(), callOne.getId());
        assertEquals(result.getDuration(), callOne.getDuration());
        assertEquals(result.getCallTime(), callOne.getCallTime());
    }

    @Test
    public void getCountByCity(){
        List<CallStatistics> statistics = callRepository.countByCity();
        assertTrue(!statistics.isEmpty());
        assertEquals(callOne.getCity(), statistics.get(0).getCity());
        assertEquals(2,statistics.get(0).getCount());
    }
}
