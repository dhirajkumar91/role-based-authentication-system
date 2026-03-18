package com.demo.auth.config;

import com.demo.auth.entity.Role;
import com.demo.auth.entity.User;
import com.demo.auth.repository.RoleRepository;
import com.demo.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // create roles if they don't exist
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_ADMIN")));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));

        Role facultyRole = roleRepository.findByName("ROLE_FACULTY")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_FACULTY")));

        // create admin user if not present
        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {

            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));

            admin.setRoles(Set.of(adminRole));

            userRepository.save(admin);
        }
    }
}