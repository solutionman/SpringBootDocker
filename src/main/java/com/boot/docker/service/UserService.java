package com.boot.docker.service;

import com.boot.docker.entity.AppUser;
import com.boot.docker.entity.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToAppUser(String appUserName, String roleName);
    AppUser getUserByName(String userName);
    List<AppUser> getAllAppUsers();
}
