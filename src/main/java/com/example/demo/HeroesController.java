package com.example.demo;

import com.example.demo.entity.Hero;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
public class HeroesController {

    @GetMapping("/")
    public String index(Model model) {
        Hero arnold = new Hero();
        Hero sylvester = new Hero();

        model.addAttribute("eventName", "Super Heroes");
        return "index";
    }

}
