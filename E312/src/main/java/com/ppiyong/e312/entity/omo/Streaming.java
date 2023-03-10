package com.ppiyong.e312.entity.omo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Streaming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mafia;
    private String road;

    @CreationTimestamp
    private Timestamp create_at;

}
