package com.example.demo;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;


@SpringBootApplication
public class DockerApplication {
    private Logger logger = LoggerFactory.getLogger(DockerApplication.class);

    @Autowired
    HeroRepository heroRepository;

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
        System.out.println("hello");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup(){
        Hero hero = new Hero();
        hero.setHeroName("Terminator");
        hero.setActorName("Arnold");
        this.heroRepository.save(hero);
        List<Hero> allHeroes = heroRepository.findAll();
        logger.info("Heroes: " + allHeroes.size());
    }
}
