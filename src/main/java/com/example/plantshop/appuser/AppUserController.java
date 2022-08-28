package com.example.plantshop.appuser;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/appuser")
@RequiredArgsConstructor
public class AppUserController {


    private final AppUserService appUserService;

    @GetMapping("/test")
    public String test() {
        return "This is test user: Konegunda Robiecicka";
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAppUsers() {
        return ResponseEntity.ok().body(appUserService.getAppUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/appuser/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveAppUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleOfUser> saveRole(@RequestBody RoleOfUser roleOfUser) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/appuser/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(roleOfUser));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        appUserService.addRoleToUser(form.getUsername(),form.getRolename());
        return ResponseEntity.ok().build();
    }


}

@Data
class RoleToUserForm{
    private String username;
    private String rolename;
}
