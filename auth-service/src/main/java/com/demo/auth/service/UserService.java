package com.demo.auth.service;

import com.demo.auth.entity.Role;
import com.demo.auth.entity.User;
import com.demo.auth.repository.RoleRepository;
import com.demo.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {

        User user =  userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")
                );

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void register(String username, String email, String password, String roleName) {

        if(userRepository.existsByEmail(email)) {
            throw new RuntimeException("User already exists");
        }

        if("ADMIN".equalsIgnoreCase(roleName)) {
            throw new RuntimeException("Cannot register as ADMIN");
        }

        Role role = roleRepository.findByName("ROLE_" + roleName.toUpperCase())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of(role));

        userRepository.save(user);
    }
}
