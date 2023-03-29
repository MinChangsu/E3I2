package com.ppiyong.e312.omo.service;

import com.ppiyong.e312.omo.entity.Person;
import com.ppiyong.e312.omo.repository.MafiaChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MafiaChartService {
    private final MafiaChartRepository mafiaChartRepository;

    public List<Person> MafiaChartList(){
        return mafiaChartRepository.findAll();
    }
    public void person(Person person){
        mafiaChartRepository.save(person);
    }
}
