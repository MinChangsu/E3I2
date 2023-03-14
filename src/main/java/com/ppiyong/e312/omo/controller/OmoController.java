package com.ppiyong.e312.omo.controller;

import com.ppiyong.e312.omo.entity.Person;
import com.ppiyong.e312.omo.entity.Streaming;
import com.ppiyong.e312.omo.service.MafiaChartService;
import com.ppiyong.e312.omo.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OmoController {
    final private StreamingService streamingService;
    final private MafiaChartService mafiaChartService;

    @GetMapping(path="/streaming")
    public List<Streaming> streamingList(){
        return streamingService.streamingList();
    }

    @GetMapping(path = "/mafia-chart")
    public List<Person> MafiaChartList() { return mafiaChartService.MafiaChartList(); }

}
