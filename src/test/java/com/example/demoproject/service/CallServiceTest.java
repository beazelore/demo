package com.example.demoproject.service;

import com.example.demoproject.model.Call;
import com.example.demoproject.repository.CallRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class CallServiceTest {
    @TestConfiguration
    static class CallServiceImplTestContextConfiguration {

        @Bean
        public CallService callService() {
            return new CallService();
        }
    }

    @InjectMocks
    private CallService callService;

    @Mock
    private CallRepository callRepository;

    private final LocalDateTime date = LocalDateTime.of(2006,4,25,21,41,6);
    private final Call call = new Call(1,null,"2412-541214-421","123-456-653",
            date,123,"Kyiv");

    @Before
    public void init(){
        Mockito.when(callRepository.getLongestCall(anyLong(),anyString(),anyString())).thenReturn(List.of(call));
        Mockito.when(callRepository.save(any())).thenReturn(call);
    }

    @Test
    public void getLongestCallForUser(){
        List<Call> result = callService.getLongestCallForPeriod(1L, date.minusDays(1).toString(), date.plusHours(1).toString());

        verify(callRepository, atLeastOnce()).getLongestCall(anyLong(),anyString(),anyString());

        assertFalse(result.isEmpty());
        assertEquals(1L, result.get(0).getId());
        assertEquals(date, result.get(0).getCallTime());
        assertEquals("Kyiv", result.get(0).getCity());
    }

    @Test
    public void successfulSaveTest(){
        Call saved = callService.addCallInfo(call);
        verify(callRepository, times(1)).save(call);
        assertEquals(saved, call);
    }



}
