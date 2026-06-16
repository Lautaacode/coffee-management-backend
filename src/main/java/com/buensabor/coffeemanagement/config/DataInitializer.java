package com.buensabor.coffeemanagement.config;

import com.buensabor.coffeemanagement.role.entity.RoleName;
import com.buensabor.coffeemanagement.role.service.RoleService;
import com.buensabor.coffeemanagement.users.service.UsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final RoleService roleService;
    private final UsersService usersService;

    public DataInitializer(RoleService roleService,
                           UsersService usersService) {
        this.roleService = roleService;
        this.usersService = usersService;
    }

    @Override
    public void run(String... args) throws Exception {

        roleService.createRoleIfNotExist(RoleName.SUPER_ADMIN);

        roleService.createRoleIfNotExist(RoleName.MANAGER);

        roleService.createRoleIfNotExist(RoleName.CASHIER);

        roleService.createRoleIfNotExist(RoleName.WAITER);

        roleService.createRoleIfNotExist(RoleName.COOK);

        usersService.createAdminIfNotExists();
    }
}

