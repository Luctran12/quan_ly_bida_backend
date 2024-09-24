package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
    public Boolean existsByUsername(String username);
}
