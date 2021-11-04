package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RolesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Transactional
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final AppUserRepository appUserRepository;
    private final RolesRepository rolesRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saved userName: {} ", appUser.getUserName());
        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saved role name: {}", role.getName());
        return rolesRepository.save(role);
    }

    @Override
    public void addRoleToAppUser(String appUserName, String roleName) {
        log.info("Role {} added to user {}", roleName, appUserName);
        AppUser appUser = appUserRepository.findAppUserByUserName(appUserName);
        Role role = rolesRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUserByName(String userName) {
        log.info("Get AppUser by name: {}", userName);
        return appUserRepository.findAppUserByUserName(userName);
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        log.info("Getting all users");
        return appUserRepository.findAll();
    }
}
