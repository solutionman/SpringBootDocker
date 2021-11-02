package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
}
