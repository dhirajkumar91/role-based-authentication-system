package com.demo.auth.controller;

import com.demo.auth.entity.User;
import com.demo.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ap1/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.getAllUsers();

        if(!userList.isEmpty()){
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
