package org.example.quan_ly_bida_backend.dataInitial;

import org.example.quan_ly_bida_backend.model.EnumRole;
import org.example.quan_ly_bida_backend.model.Food;
import org.example.quan_ly_bida_backend.model.Role;
import org.example.quan_ly_bida_backend.repository.FoodRepo;
import org.example.quan_ly_bida_backend.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepo roleRepo;
    private final FoodRepo foodRepo;

    public DataInitializer(RoleRepo roleRepo, FoodRepo foodRepo) {
        this.roleRepo = roleRepo;
        this.foodRepo = foodRepo;
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

    }
}
