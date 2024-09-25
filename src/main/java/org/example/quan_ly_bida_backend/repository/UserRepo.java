package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.EnumRole;
import org.example.quan_ly_bida_backend.model.Role;
import org.example.quan_ly_bida_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
    public Boolean existsByUsername(String username);
    public List<User> findByRole(Role role);
    public User findById(int id);
}
