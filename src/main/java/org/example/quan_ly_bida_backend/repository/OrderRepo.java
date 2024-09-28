package org.example.quan_ly_bida_backend.repository;

import org.example.quan_ly_bida_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
   // Order findById(Long orderId);
   // public Order updateById(Order order);
}
