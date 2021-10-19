package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Hero {
    @Id
    private Long id;
    String actorName;
    String heroName;
}
