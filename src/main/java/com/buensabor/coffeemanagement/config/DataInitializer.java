package com.buensabor.coffeemanagement.config;

import com.buensabor.coffeemanagement.role.entity.RoleName;
import com.buensabor.coffeemanagement.role.service.RoleService;
import com.buensabor.coffeemanagement.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService,
                           UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        roleService.createRoleIfNotExist(RoleName.SUPER_ADMIN);

        roleService.createRoleIfNotExist(RoleName.MANAGER);

        roleService.createRoleIfNotExist(RoleName.CASHIER);

        roleService.createRoleIfNotExist(RoleName.WAITER);

        roleService.createRoleIfNotExist(RoleName.COOK);

        userService.createAdminIfNotExists();
    }
}

