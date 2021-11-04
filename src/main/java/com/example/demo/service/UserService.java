package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToAppUser(String appUserName, String roleName);
    AppUser getUserByName(String userName);
    List<AppUser> getAllAppUsers();
}
