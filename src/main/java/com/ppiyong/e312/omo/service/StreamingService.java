package com.ppiyong.e312.omo.service;

import com.ppiyong.e312.omo.entity.Streaming;
import com.ppiyong.e312.omo.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingService {
    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> streamingList(){
        return streamingRepository.findAll();
    }

    public void streaming(Streaming streaming) {
        streamingRepository.save(streaming);
    }
}
