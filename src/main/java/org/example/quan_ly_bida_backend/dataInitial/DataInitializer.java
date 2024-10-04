package org.example.quan_ly_bida_backend.dataInitial;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
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
        food.setCost(10000L);
        food.setName("Kem");
        food.setImageUrl("../../assets/Food/kem.png");
        foodRepo.save(food);


        Food food1 = new Food();
        food1.setName("Mì tôm");
        food1.setCost(13000L);
        foodRepo.save(food1);

        Food food2 = new Food();
        food2.setName("Nui xào");
        food2.setCost(30000L);
        food.setImageUrl("../../assets/Food/nui.png");
        foodRepo.save(food2);

        Food food3 = new Food();
        food3.setName("Sting");
        food3.setCost(15000L);
        foodRepo.save(food3);

        Food food4 = new Food();
        food4.setName("Pepsi");
        food4.setCost(15000L);
        foodRepo.save(food4);

        Food food5 = new Food();
        food5.setName("Cà Phê");
        food5.setCost(15000L);
        foodRepo.save(food5);

        Food food6 = new Food();
        food6.setName("Cà phê sữa");
        food6.setCost(20000L);
        foodRepo.save(food6);

        Food food7 = new Food();
        food7.setName("Trà Đào");
        food7.setCost(20000L);
        foodRepo.save(food7);

        Food food8 = new Food();
        food8.setName("Trà Đá");
        food8.setCost(5000L);
        foodRepo.save(food8);

        Food food9 = new Food();
        food9.setName("Sting");
        food9.setCost(15000L);
        foodRepo.save(food9);

        BilliardTable b = new BilliardTable();
        b.setCostPerHour(39000L);
        b.setType("Aplus");
        billiardTableRepo.save(b);

        BilliardTable b1 = new BilliardTable();
        b1.setCostPerHour(39000L);
        b1.setType("Aplus2");
        billiardTableRepo.save(b1);

        BilliardTable b2 = new BilliardTable();
        b2.setCostPerHour(39000L);
        b2.setType("Aplus3");
        billiardTableRepo.save(b2);

        BilliardTable b3 = new BilliardTable();
        b3.setCostPerHour(39000L);
        b3.setType("Aplus4");
        billiardTableRepo.save(b3);

        BilliardTable b4 = new BilliardTable();
        b4.setCostPerHour(49000L);
        b4.setType("MrSung2");
        billiardTableRepo.save(b4);

        BilliardTable b5 = new BilliardTable();
        b5.setCostPerHour(39000L);
        b5.setType("MrSung3");
        billiardTableRepo.save(b5);

        BilliardTable b6 = new BilliardTable();
        b6.setCostPerHour(79000L);
        b6.setType("Chinese Pool");
        billiardTableRepo.save(b6);

        BilliardTable b7 = new BilliardTable();
        b7.setCostPerHour(79000L);
        b7.setType("Chinese Pools");
        billiardTableRepo.save(b7);

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

        System.out.println("===================================");
        LocalDate date = LocalDate.of(2024,10,4);
        System.out.println(date);
        System.out.println(statusRepo.findByDate(date).size());
        //System.out.println(statusRepo.findByDate("2024-10-02").toArray().length);

        System.out.println("findAll: ");
        for(Status s : statusRepo.findAll()) {
            System.out.println(s.toString());
        }
    }
}
