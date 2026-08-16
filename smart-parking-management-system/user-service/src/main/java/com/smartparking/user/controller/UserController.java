package com.smartparking.user.controller;

import com.smartparking.user.entity.User;
import com.smartparking.user.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @PostMapping public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(user));
    }
    @GetMapping public List<User> all() { return service.findAll(); }
    @GetMapping("/{id}") public User get(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @RequestBody User user) { return service.update(id, user); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
    @PostMapping("/login") public User login(@RequestBody Map<String,String> body) {
        return service.login(body.get("email"), body.get("password"));
    }
}
