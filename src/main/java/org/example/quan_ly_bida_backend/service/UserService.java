package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.UserCreationRequest;
import org.example.quan_ly_bida_backend.model.EnumRole;
import org.example.quan_ly_bida_backend.model.Role;
import org.example.quan_ly_bida_backend.model.User;
import org.example.quan_ly_bida_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Boolean login(UserCreationRequest userRequest) {
        if(userRepo.existsByUsername(userRequest.getUserName())) {
            User user = new User(userRepo.findByUsername(userRequest.getUserName()));
            if(userRequest.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public User createUser(UserCreationRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());

        //All user have role user just 1 admin
        Role userRole = new Role();
        userRole.setRole(EnumRole.USER);
        user.setRole(userRole);

        userRepo.save(user);
        return user;
    }

    public String deleteUser(int userId) {
        userRepo.deleteById(userId);
        return "deleted";
    }
}
