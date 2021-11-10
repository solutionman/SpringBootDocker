package com.example.demo;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Hero;
import com.example.demo.entity.Role;
import com.example.demo.repository.HeroRepository;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@SpringBootApplication
public class DockerApplication {
    private final Logger logger = LoggerFactory.getLogger(DockerApplication.class);

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
        System.out.println("hello");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        Hero hero = new Hero();
        hero.setHeroName("Terminator");
        hero.setActorName("Arnold");
        this.heroRepository.save(hero);
        List<Hero> allHeroes = heroRepository.findAll();
        logger.info("Heroes: {}", allHeroes.size());

        if (userRepository.findAppUserByUserName("User") != null && userRepository.findAppUserByUserName("Admin") != null) {
            AppUser user = new AppUser();
            user.setUserName("User");
            user.setPassword(passwordEncoder.encode("12345678"));
            userRepository.save(user);
            logger.info("User: {} Pass: {}", user.getUserName(), user.getPassword());

            AppUser userAdmin = new AppUser();
            userAdmin.setUserName("Admin");
            userAdmin.setPassword(passwordEncoder.encode("87654321"));
            userRepository.save(userAdmin);
            logger.info("User: {} Pass: {}", userAdmin.getUserName(), userAdmin.getPassword());
        } else {
            logger.info("User or Admin already exists in database");
        }
    }

    // Another way to add something to DB after start application
    @Bean
    CommandLineRunner run(UserService userService) {

        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new AppUser(null, "SuperUser", passwordEncoder.encode("12345678"), new HashSet<>()));
            userService.addRoleToAppUser("SuperUser", "ROLE_USER");

            userService.saveUser(new AppUser(null, "SuperAdmin", passwordEncoder.encode("87654321"), new HashSet<>()));
            userService.addRoleToAppUser("SuperAdmin", "ROLE_ADMIN");
        };
    }
}
