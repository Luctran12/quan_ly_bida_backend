package org.example.quan_ly_bida_backend.controller;

import org.example.quan_ly_bida_backend.dto.request.UserCreationRequest;
import org.example.quan_ly_bida_backend.model.User;
import org.example.quan_ly_bida_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public boolean login(@RequestBody UserCreationRequest user) {
        if (userService.login(user)) {
            return true;
        }
        return false;
    }

    @PostMapping("/create")
    public User create(@RequestBody UserCreationRequest user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody UserCreationRequest user) {
        return "";
    }
}
