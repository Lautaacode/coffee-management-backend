package com.buensabor.coffeemanagement.user.service.impl;

import com.buensabor.coffeemanagement.role.entity.Role;
import com.buensabor.coffeemanagement.role.entity.RoleName;
import com.buensabor.coffeemanagement.role.repository.RoleRepository;
import com.buensabor.coffeemanagement.user.entity.User;
import com.buensabor.coffeemanagement.user.repository.UserRepository;
import com.buensabor.coffeemanagement.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {

        User existing = findById(id);

        existing.setName(user.getName());
        existing.setLastName(user.getLastName());
        existing.setDni(user.getDni());
        existing.setEmail(user.getEmail());

        if (user.getPassword() != null &&
                !user.getPassword().isBlank()) {

            existing.setPassword(
                    passwordEncoder.encode(user.getPassword())
            );
        }

        return userRepository.save(existing);
    }

    @Override
    public void delete(Long id) {

        User user = findById(id);

        userRepository.delete(user);
    }

    @Override
    public void createAdminIfNotExists() {

        String adminEmail = "admin@coffee.com";

        if (userRepository.existsByEmail(adminEmail)) {
            return;
        }

        Role adminRole = roleRepository.findByName(RoleName.SUPER_ADMIN)
                .orElseThrow(() -> new RuntimeException("Role SUPER_ADMIN not found"));

        User admin = new User();

        admin.setName("Super");
        admin.setLastName("Admin");
        admin.setDni("00000000");
        admin.setEmail(adminEmail);

        admin.setPassword(
                passwordEncoder.encode("Admin123")
        );

        admin.setRoles(Set.of(adminRole));

        userRepository.save(admin);
    }
}