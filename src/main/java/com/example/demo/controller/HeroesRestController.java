package com.example.demo.controller;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;
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
        return hero.getHeroName();
    }
}
