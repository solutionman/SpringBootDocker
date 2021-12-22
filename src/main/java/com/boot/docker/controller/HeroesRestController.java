package com.boot.docker.controller;

import com.boot.docker.repository.HeroRepository;
import com.boot.docker.entity.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/heroes")
public class HeroesRestController {

    @Autowired
    HeroRepository heroRepository;

    @GetMapping(path = "{heroId}")
    public String  getHero(@PathVariable("heroId") Long id){
        Hero hero = heroRepository.getOne(id);
        return hero.toString();
    }
}
