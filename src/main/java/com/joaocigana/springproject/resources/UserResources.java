package com.joaocigana.springproject.resources;

import com.joaocigana.springproject.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "João Cigana", "joao@gmail.com", "(55) 99106-6888", "passphrase");
        return ResponseEntity.ok().body(u);
    }

}
