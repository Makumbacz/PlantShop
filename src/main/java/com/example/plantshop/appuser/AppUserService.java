package com.example.plantshop.appuser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(username);
        if(appUser == null){
            log.error("User not found in db!");
            throw new UsernameNotFoundException("User not found in db!");
        }
        log.info("User found! : {}",username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppUserRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getEmail(),appUser.getPassword(), authorities);
    }

    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user to db : {}", appUser.getEmail());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }
    public RoleOfUser saveRole(RoleOfUser role){
        log.info("Saving new role to db: {}", role.getName());
        return roleRepository.save(role);
    }

   public void addRoleToUser(String firstname, String roleName){
        log.info("Adding Role to user: {}, Role: {}",firstname ,roleName);
        AppUser appUser = appUserRepository.findByFirstname(firstname);
        RoleOfUser roleOfUser = roleRepository.findByName(roleName);
        appUser.getAppUserRoles().add(roleOfUser);
    }
    public AppUser getUser(String username){
        log.info("Fetching user :{}", username);
        return appUserRepository.findByFirstname(username);
    }
    public List<AppUser> getAppUsers(){
        log.info("Fetching all users");
        return appUserRepository.findAll();
    }

}
