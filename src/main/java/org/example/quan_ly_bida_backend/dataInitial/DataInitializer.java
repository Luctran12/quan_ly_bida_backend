package org.example.quan_ly_bida_backend.dataInitial;

import org.example.quan_ly_bida_backend.model.*;
import org.example.quan_ly_bida_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepo roleRepo;
    private final FoodRepo foodRepo;
    private final BilliardTableRepo billiardTableRepo;
    private final OrderRepo orderRepo;
    private final StatusRepo statusRepo;
    private final OrderFoodItemRepo orderFoodItemRepo;


    public DataInitializer(RoleRepo roleRepo, FoodRepo foodRepo,
                           BilliardTableRepo billiardTableRepo,
                           OrderRepo orderRepo, StatusRepo statusRepo,
                           OrderFoodItemRepo orderFoodItemRepo) {
        this.roleRepo = roleRepo;
        this.foodRepo = foodRepo;
        this.billiardTableRepo = billiardTableRepo;
        this.orderRepo = orderRepo;
        this.statusRepo = statusRepo;
        this.orderFoodItemRepo = orderFoodItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setRole(EnumRole.ADMIN);
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRole(EnumRole.USER);
        roleRepo.save(userRole);

        Food food = new Food();
        food.setCost(12000L);
        food.setName("Mỳ gói");
        foodRepo.save(food);

        food.setName("trà đá");
        food.setCost(5000L);
        foodRepo.save(food);

        BilliardTable b = new BilliardTable();
        b.setCostPerHour(20000L);
        b.setType("Aplus");
        billiardTableRepo.save(b);

        OrderFoodItem orderFoodItem = new OrderFoodItem();
        orderFoodItem.setFood(food);
        orderFoodItem.setQuantity(3);


        Order order = new Order();

        orderFoodItem.setOrder(order);
        orderFoodItem.setTable(b);
        order.getOrderFoodItems().add(orderFoodItem);
        order.setTotalCost(order.calculateTotalCost());
        //orderRepo.save(order);


        Status status = new Status();
        status.setOrder(order);
        status.setBilliardTable(b);
        status.setStartTime(new Date(10000));
        status.setEndTime(new Date(20002));
        status.setTotalTime(new Date(10002));
        status.setTotalCost(status.getOrder().getTotalCost()+status.getBilliardTable().getCostPerHour() * 0.5);
        statusRepo.save(status);
    }
}
