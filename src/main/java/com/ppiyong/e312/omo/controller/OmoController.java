package com.ppiyong.e312.omo.controller;

import com.ppiyong.e312.omo.entity.Person;
import com.ppiyong.e312.omo.entity.Streaming;
import com.ppiyong.e312.omo.service.MafiaChartService;
import com.ppiyong.e312.omo.service.StreamingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OmoController {
    final private StreamingService streamingService;
    final private MafiaChartService mafiaChartService;

    @GetMapping(path="/streaming")
    public List<Streaming> streamingList(){
        return streamingService.streamingList();
    }

    @GetMapping(path = "/mafia-chart")
    public List<Person> MafiaChartList() {
        return mafiaChartService.MafiaChartList();
    }
    @PostMapping("/mafia-chart")
    public void person(@RequestBody Person person){
        mafiaChartService.person(person);

    }
    @PostMapping("/streaming")
    public void streaming(@RequestBody Streaming streaming){
        streamingService.streaming(streaming);

    }
}

