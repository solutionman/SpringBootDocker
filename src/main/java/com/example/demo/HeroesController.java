package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
public class HeroesController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("eventName", "Super Heroes");
        return "index";
    }

}
