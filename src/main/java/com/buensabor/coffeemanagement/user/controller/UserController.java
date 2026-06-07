package com.buensabor.coffeemanagement.user.controller;

import com.buensabor.coffeemanagement.user.entity.User;
import com.buensabor.coffeemanagement.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<User> create(
            @RequestBody User user
    ) {

        return ResponseEntity.ok(
                service.create(user)
        );
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<List<User>> findAll() {

        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<User> findById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @RequestBody User user
    ) {

        return ResponseEntity.ok(
                service.update(id, user)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}