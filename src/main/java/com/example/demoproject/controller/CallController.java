package com.example.demoproject.controller;

import com.example.demoproject.projection.CallStatistics;
import com.example.demoproject.model.Call;
import com.example.demoproject.service.CallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
public class CallController {
    private CallService callService;
    public CallController(CallService callService){
        this.callService = callService;
    }

    @GetMapping("/numberByCity")
    public List<CallStatistics> countByCity(){
        return callService.countByCity();
    }

    @GetMapping("/longest")
    @ResponseBody
    public List<Call> getLongest(@RequestParam Long id, @RequestParam String startDate, @RequestParam String endDate){
        return callService.getLongestCallForPeriod(id,startDate,endDate);
    }

    @PostMapping
    public Call saveCallInfo(@RequestBody Call call){
        return callService.addCallInfo(call);
    }
}
