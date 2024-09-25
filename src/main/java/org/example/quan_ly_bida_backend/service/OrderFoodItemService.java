package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.model.OrderFoodItem;
import org.example.quan_ly_bida_backend.repository.OrderFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFoodItemService {
    @Autowired
    OrderFoodItemRepo orderFoodItemRepo;

    public List<OrderFoodItem> findByTableId(int tableId) {
     return orderFoodItemRepo.findByTableId(tableId);
    }

    public OrderFoodItem createOrderFoodItem(OrderFoodItem orderFoodItem) {
        return orderFoodItemRepo.save(orderFoodItem);
    }

}
