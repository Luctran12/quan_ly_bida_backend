package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.FoodCreationRequest;
import org.example.quan_ly_bida_backend.model.Food;
import org.example.quan_ly_bida_backend.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepo foodRepo;

    public Food findFoodById(int id) {
        Food food = null;
        food = foodRepo.findById(id);
        return food;
    }

    public Food createFood(FoodCreationRequest foodreq) {
        Food food = new Food();
        food.setName(foodreq.getName());
        food.setCost(foodreq.getCost());
        return foodRepo.save(food);
    }

    public List<Food> findAllFood() {
        return foodRepo.findAll();
    }
}
