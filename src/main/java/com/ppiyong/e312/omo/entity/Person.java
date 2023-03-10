package com.ppiyong.e312.omo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String road1;
    private String road1_mafia;
    private String road2;
    private String road2_mafia;
    private String road3;
    private String road3_mafia;
    private String road4;
    private String road4_mafia;
    @CreationTimestamp
    private Timestamp create_at;
}
