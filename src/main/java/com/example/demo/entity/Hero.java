package com.example.demo.entity;

import lombok.Data;

@Data
public class Hero {
    String actorName;
    String heroName;
    public Hero(String actorName, String heroName){
        this.actorName = actorName;
        this.heroName = heroName;
    }
}
