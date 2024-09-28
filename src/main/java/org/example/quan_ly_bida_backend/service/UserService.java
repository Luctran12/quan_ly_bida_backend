package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.UserCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.UserLoginRequest;
import org.example.quan_ly_bida_backend.model.EnumRole;
import org.example.quan_ly_bida_backend.model.Role;
import org.example.quan_ly_bida_backend.model.User;
import org.example.quan_ly_bida_backend.repository.RoleRepo;
import org.example.quan_ly_bida_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    public User login(UserLoginRequest userRequest) {
        if(userRepo.existsByUsername(userRequest.getUserName())) {
            User user = new User(userRepo.findByUsername(userRequest.getUserName()));
            if(userRequest.getPassword().equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public User createUser(UserCreationRequest userRequest) throws SQLIntegrityConstraintViolationException {
        if(userRepo.existsByUsername(userRequest.getUserName())) {
            throw new SQLIntegrityConstraintViolationException("Username already exists");
        }
        User user = new User();
        user.setUsername(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setFullName(userRequest.getFullName());

        //All user have role user just 1 admin
        Role userRole = roleRepo.findByRoleName(EnumRole.USER);
        user.setRole(userRole);

        userRepo.save(user);
        return user;
    }

    public String deleteUser(int userId) {
        userRepo.deleteById(userId);
        return "deleted";
    }

    public List<User> getAllUsersHaveRoleUser() {
        Role userRole = roleRepo.findByRoleName(EnumRole.USER);
        List<User> users = userRepo.findByRole(userRole);
        return users;
    }

    public User getUser(int userId) {

        return userRepo.findById(userId);
    }
}
