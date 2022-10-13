package edu.miu.cs590.accountservice.controller;

import edu.miu.cs590.accountservice.dto.AppUserResponse;
import edu.miu.cs590.accountservice.model.AppUser;
import edu.miu.cs590.accountservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public List<AppUserResponse> getAllUser(){
        return appUserService.getAllUser();
    }


    @GetMapping("/{id}")
    public AppUserResponse getUserById(@PathVariable Long id){
        return appUserService.getUserById(id);
    }

    @GetMapping("/login/{userName}")
    public AppUser getUser(@PathVariable String userName){
        return appUserService.getUser(userName);
    }
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody AppUser appUser){
        appUserService.createUser(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody AppUser appUser,Long id){
        if (appUserService.updateUser(id,appUser)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>("User Not Found",HttpStatus.BAD_REQUEST);


    }
}
