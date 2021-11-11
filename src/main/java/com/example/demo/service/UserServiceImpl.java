package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RolesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Transactional
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByUserName(username);
        if(appUser == null){
            log.error("Not found user: {} in Database", username);
            throw new UsernameNotFoundException("User not found");
        } else {
            log.error("User: {} found in Database", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getUserName(), appUser.getPassword(), authorities);
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saved userName: {} ", appUser.getUserName());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
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
