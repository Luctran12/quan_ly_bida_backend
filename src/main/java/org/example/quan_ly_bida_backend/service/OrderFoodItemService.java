package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.OrderFoodItemCreationRequest;
import org.example.quan_ly_bida_backend.model.BilliardTable;
import org.example.quan_ly_bida_backend.model.Food;
import org.example.quan_ly_bida_backend.model.Order;
import org.example.quan_ly_bida_backend.model.OrderFoodItem;
import org.example.quan_ly_bida_backend.repository.BilliardTableRepo;
import org.example.quan_ly_bida_backend.repository.FoodRepo;
import org.example.quan_ly_bida_backend.repository.OrderFoodItemRepo;
import org.example.quan_ly_bida_backend.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFoodItemService {
    @Autowired
    OrderFoodItemRepo orderFoodItemRepo;

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    BilliardTableRepo billiardTableRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    OrderService orderService;

    public List<OrderFoodItem> findByTableId(int tableId) {
     return orderFoodItemRepo.findByTableId(tableId);
    }

//    public OrderFoodItem createOrderFoodItem(OrderFoodItemCreationRequest orderFoodItem) {
//        Food food = food = orderFoodItem.getFood();
//        Food existingFood = foodRepo.findByName(food.getName());
//        if (existingFood == null) {
//            foodRepo.save(food);
//        }
//        OrderFoodItem order = new OrderFoodItem();
//        order.setFood(orderFoodItem.getFood());
//        order.setQuantity(orderFoodItem.getQuantity());
//        order.setTable(orderFoodItem.getTable());
//        orderFoodItemRepo.save(order);
//
//        return order;
//    }

    public OrderFoodItem createOrderFoodItem(OrderFoodItemCreationRequest orderFoodItemRequest) {
        // get object food from database by food id
        Food food = foodRepo.findById(orderFoodItemRequest.getFoodId()) ;

        // Kiểm tra xem Food đã tồn tại trong DB chưa
//        Food existingFood = foodRepo.findByName(food.getName());
//        if (existingFood == null) {
//            // Nếu Food chưa tồn tại, lưu vào DB
//            food = foodRepo.save(food);
//        } else {
//            // Nếu Food đã tồn tại, sử dụng Food đó
//            food = existingFood;
//        }

        BilliardTable table = billiardTableRepo.findById(orderFoodItemRequest.getTableId()).get();

//        BilliardTable existTable = billiardTableRepo.findByType(table.getType());
//        if (existTable == null) {
//            billiardTableRepo.save(table);
//        }else {
//            table = existTable;
//        }

        //add order
        Order order = orderRepo.findById(orderFoodItemRequest.getOrderId()).get();

        // Tạo đối tượng OrderFoodItem
        OrderFoodItem orderFoodItem = new OrderFoodItem();
        orderFoodItem.setFood(food);  // Sử dụng food đã kiểm tra
        orderFoodItem.setQuantity(orderFoodItemRequest.getQuantity());
        orderFoodItem.setTable(table);
        orderFoodItem.setOrder(order);

        //save totalcost for Order
        orderService.orderTotalCost(order.getId());

        // Lưu OrderFoodItem
        orderFoodItemRepo.save(orderFoodItem);

        return orderFoodItem;
    }

    public List<OrderFoodItem> getAllOrderFoodItems() {
        return orderFoodItemRepo.findAll();
    }

    public OrderFoodItem addOrderTable(int oderFoodItemId,Long orderTableId) {
        OrderFoodItem orderFoodItem = orderFoodItemRepo.findById(oderFoodItemId).get();
        orderFoodItem.setOrder(orderRepo.findById(orderTableId).get());
        orderFoodItemRepo.save(orderFoodItem);
        return orderFoodItem;
    }

}
