package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.EnumRole;
import org.example.quan_ly_bida_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.role = :role")
    Role findByRoleName(@Param("role") EnumRole role);
}
