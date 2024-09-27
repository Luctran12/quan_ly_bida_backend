package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.BilliardTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilliardTableRepo extends JpaRepository<BilliardTable, Integer> {
    public BilliardTable findByType(String type);
}
