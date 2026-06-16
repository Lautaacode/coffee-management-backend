package com.buensabor.coffeemanagement.users.service.impl;

import com.buensabor.coffeemanagement.role.entity.Role;
import com.buensabor.coffeemanagement.role.entity.RoleName;
import com.buensabor.coffeemanagement.role.repository.RoleRepository;
import com.buensabor.coffeemanagement.users.entity.Users;
import com.buensabor.coffeemanagement.users.repository.UsersRepository;
import com.buensabor.coffeemanagement.users.service.UsersService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository,
                            RoleRepository roleRepository,
                            PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users create(Users user) {

        if (usersRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return usersRepository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users update(Long id, Users users) {

        Users existing = findById(id);

        existing.setName(users.getName());
        existing.setLastName(users.getLastName());
        existing.setDni(users.getDni());
        existing.setEmail(users.getEmail());

        if (users.getPassword() != null &&
                !users.getPassword().isBlank()) {

            existing.setPassword(
                    passwordEncoder.encode(users.getPassword())
            );
        }

        return usersRepository.save(existing);
    }

    @Override
    public void delete(Long id) {

        Users users = findById(id);

        usersRepository.delete(users);
    }

    @Override
    public void createAdminIfNotExists() {

        String adminEmail = "admin@coffee.com";

        if (usersRepository.existsByEmail(adminEmail)) {
            return;
        }

        Role adminRole = roleRepository.findByName(RoleName.SUPER_ADMIN)
                .orElseThrow(() -> new RuntimeException("Role SUPER_ADMIN not found"));

        Users admin = new Users();

        admin.setName("Super");
        admin.setLastName("Admin");
        admin.setDni("00000000");
        admin.setEmail(adminEmail);

        admin.setPassword(
                passwordEncoder.encode("Admin123")
        );

        admin.setRoles(Set.of(adminRole));

        usersRepository.save(admin);
    }
}