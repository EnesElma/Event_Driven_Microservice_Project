package com.enes.user.controller;

import com.enes.user.entity.User;
import com.enes.user.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService service;
    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveUser(@RequestBody User user){

        return ResponseEntity.ok(service.saveOrUpdateUser(user));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        service.deleteUser(id);
        return ResponseEntity.ok("Kullanıcı silindi");
    }

    @GetMapping("all")
    public ResponseEntity<?> findAll(){
        System.out.println("findAll");
        return ResponseEntity.ok(service.findAll());
    }
}
