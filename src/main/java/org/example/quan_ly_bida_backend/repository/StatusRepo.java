package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer> {
}
