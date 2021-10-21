package com.example.demo;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class HeroesController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/")
    public String index(Model model) {
        Hero hero = new Hero();
        hero.setHeroName("Terminator");
        hero.setActorName("Arnold");
        this.heroRepository.save(hero);
        List<Hero> heroes = this.heroRepository.findAll();
        java.lang.System.out.println("search in hero repository");
        model.addAttribute("hero", heroes.get(0).getHeroName());

        model.addAttribute("test", "test");

        model.addAttribute("eventName", "Super Heroes");
        return "index";
    }

}
