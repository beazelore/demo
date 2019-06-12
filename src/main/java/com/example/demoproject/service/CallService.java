package com.example.demoproject.service;

import com.example.demoproject.projection.CallStatistics;
import com.example.demoproject.model.Call;
import com.example.demoproject.repository.CallRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CallService {
    private CallRepository callRepository;
    @Autowired
    public CallService(CallRepository callRepository){
        this.callRepository = callRepository;
    }
    public List<CallStatistics> countByCity(){
        return callRepository.countByCity();
    }

    public List<Call> getLongestCallForPeriod(long id, String startDate, String endDate){
        return callRepository.getLongestCall(id,startDate, endDate);
    }

    public Call addCallInfo(Call call){
        return callRepository.save(call);
    }
}
