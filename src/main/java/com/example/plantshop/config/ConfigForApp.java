package com.example.plantshop.config;

import com.example.plantshop.appuser.AppUser;
import com.example.plantshop.appuser.AppUserRepository;
import com.example.plantshop.appuser.AppUserService;
import com.example.plantshop.appuser.RoleOfUser;
import com.example.plantshop.plant.Plant;
import com.example.plantshop.plant.PlantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ConfigForApp {
   /* @Bean
    CommandLineRunner commandLineRunnerAddPlants(PlantRepository plantRepository){
        return args -> {
            Plant plant = new Plant();
        };
    }
    @Bean
    CommandLineRunner commandLineRunnerAddUsers(AppUserRepository appUserRepository){
        return args -> {
            Plant plant = new Plant();
        };
    }
*   */
    @Bean
    CommandLineRunner run(AppUserService userService){
        return args -> {
            userService.saveRole(new RoleOfUser(null,"ROLE_USER"));
            userService.saveRole(new RoleOfUser(null,"ROLE_MANAGER"));
            userService.saveRole(new RoleOfUser(null,"ROLE_ADMIN"));
            userService.saveRole(new RoleOfUser(null,"ROLE_SUPER_ADMIN"));

            userService.saveAppUser(new AppUser(null,"Robert","Kubica","moznalatwoutknacwkorku@gmail.com","EEEE",new ArrayList<>()));
            userService.saveAppUser(new AppUser(null,"Pierre","Gasly","kitajec@gmail.com","EEEE",new ArrayList<>()));
            userService.saveAppUser(new AppUser(null,"Daniel","Riccardo","ogur@gmail.com","EEEE",new ArrayList<>()));
            userService.saveAppUser(new AppUser(null,"Carlos","Sainz","p3@gmail.com","EEEE",new ArrayList<>()));

            userService.addRoleToUser("Carlos", "ROLE_USER");
            userService.addRoleToUser("Robert", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Pierre", "ROLE_MANAGER");
            userService.addRoleToUser("Daniel", "ROLE_USER");
            userService.addRoleToUser("Carlos", "ROLE_ADMIN");

        };
    }
}
