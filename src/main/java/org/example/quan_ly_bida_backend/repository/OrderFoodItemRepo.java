package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.OrderFoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFoodItemRepo extends JpaRepository<OrderFoodItem, Integer> {
    public List<OrderFoodItem> findByTableId(int tableId);
}
