package com.softserve.demoproject.service;

import com.softserve.demoproject.model.Call;
import com.softserve.demoproject.projection.CallStatistics;
import com.softserve.demoproject.repository.CallRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CallService {
    private CallRepository callRepository;
    public CallService(CallRepository callRepository){
        this.callRepository = callRepository;
    }
    public Iterable<CallStatistics> countByCity(){
        return callRepository.countByCity();
    }

    public List<Call> getLongestCallForPeriod(long id, String startDate, String endDate){
        return callRepository.getLongestCall(id,startDate, endDate);
    }

    public Call addCallInfo(Call call){
        return callRepository.save(call);
    }
}
