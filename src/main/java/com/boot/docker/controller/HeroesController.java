package com.boot.docker.controller;

import com.boot.docker.entity.Hero;
import com.boot.docker.repository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class HeroesController {

    private final Logger logger = LoggerFactory.getLogger(HeroesController.class);

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/")
    public String index(Model model) {
        Hero hero = new Hero();
        hero.setHeroName("Terminator");
        hero.setActorName("Arnold");
        this.heroRepository.save(hero);
        List<Hero> heroes = this.heroRepository.findAll();
        logger.info("search in hero repository");
        if(!heroes.isEmpty()){
            for(Hero h : heroes){
                logger.info("Actor name {} Hero name {}",h.getActorName(), h.getHeroName());
            }
        }
        model.addAttribute("hero", heroes.get(0).getHeroName());

        model.addAttribute("test", "test");

        model.addAttribute("eventName", "Super Heroes");
        return "index";
    }

}
