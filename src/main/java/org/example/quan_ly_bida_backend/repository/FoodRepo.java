package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {
}
