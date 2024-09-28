package org.example.quan_ly_bida_backend.dataInitial;

import org.example.quan_ly_bida_backend.model.*;
import org.example.quan_ly_bida_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

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

        Food food1 = new Food();
        food1.setName("trà đá");
        food1.setCost(5000L);
        foodRepo.save(food1);

        Food food2 = new Food();
        food2.setName("trà đường");
        food2.setCost(15000L);
        foodRepo.save(food2);

        Food food3 = new Food();
        food3.setName("trà đá");
        food3.setCost(5000L);
        foodRepo.save(food3);

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
        status.setStartTime(LocalTime.of(14,0));
        status.setEndTime(LocalTime.of(16,0));
        status.setTotalTime(LocalTime.of(2,0));
        status.setTotalCost(status.getOrder().getTotalCost()+status.getBilliardTable().getCostPerHour() * 0.5);
        status.setDate(LocalDate.now());
        statusRepo.save(status);
    }
}
