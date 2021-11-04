package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class AppUserRestController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllAppUsers(){
        String debug = "";
        return ResponseEntity.ok().body(userService.getAllAppUsers());
    }
}
