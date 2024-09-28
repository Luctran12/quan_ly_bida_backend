package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.OrderFoodItemCreationRequest;
import org.example.quan_ly_bida_backend.model.Order;
import org.example.quan_ly_bida_backend.model.OrderFoodItem;
import org.example.quan_ly_bida_backend.repository.OrderFoodItemRepo;
import org.example.quan_ly_bida_backend.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderFoodItemRepo orderFoodItemRepo;

    public Long orderTotalCost(Long id) {
        if(orderRepo.existsById(id)){
            Order order = orderRepo.findById(id).get();
            Long totalCost = order.calculateTotalCost();
            order.setTotalCost(totalCost);
            orderRepo.save(order);
            return totalCost;
        }else{
            return null;
        }
    }

    public Order createOrder() {
        Order order = new Order();
        orderRepo.save(order);
        return order;
    }

//    public Order addOrderFoodItem(int orderFoodItemId, Long orderId) {
//        Order order = orderRepo.findById(orderId).get();
//
//    }
}
