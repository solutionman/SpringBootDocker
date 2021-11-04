package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new HashSet<>();
}
