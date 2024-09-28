package org.example.quan_ly_bida_backend.controller;

import jakarta.validation.Valid;
import org.example.quan_ly_bida_backend.dto.request.UserCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.UserLoginRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.model.User;
import org.example.quan_ly_bida_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ApiResponse<User> login(@RequestBody @Valid UserLoginRequest user) {
        ApiResponse<User> response = new ApiResponse();
        try {
            response.setResult(userService.login(user));
            response.setCode(200);
            response.setMsg("login successfully");
            return response;
        }catch(Exception e)
        {
            response.setMsg("login failed: "+e.getMessage());
        }
        response.setMsg("login failed, userName or password is incorrect");
        return response;
    }


    @PostMapping("/create")
    public ApiResponse<User>  create(@RequestBody  UserCreationRequest user) {
        ApiResponse<User> response = new ApiResponse<>();

        try {
            response.setResult(userService.createUser(user));
            response.setMsg("create successfully");
        } catch (SQLIntegrityConstraintViolationException e) {
            response.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return response;
    }


    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable int id) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setResult(userService.deleteUser(id));
        response.setMsg("delete account successfully");
        return response;
    }


    @GetMapping("/getAllStaff")
    public ApiResponse<List<User>> getAllStaff() {
        ApiResponse<List<User>> response = new ApiResponse<>();
        response.setResult(userService.getAllUsersHaveRoleUser());
        if(response.getResult().size() > 0) {
            response.setCode(200);
            response.setMsg("getAllStaff successfully");
        }else{
            response.setCode(500);
            response.setMsg("getAllStaff failed");
        }

        return response;
    }

    @GetMapping("/getById/{id}")
    public ApiResponse<User> getById(@PathVariable int id) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.getUser(id));
        if(response.getResult()!= null) {
            response.setMsg("getById successfully");
        }else{
            response.setMsg("getById failed");
        }
        return response;
    }
}
