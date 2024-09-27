package org.example.quan_ly_bida_backend.controller;

import org.example.quan_ly_bida_backend.dto.request.FoodCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.model.Food;
import org.example.quan_ly_bida_backend.repository.FoodRepo;
import org.example.quan_ly_bida_backend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/getById/{id}")
    public ApiResponse<Food> getById(@PathVariable int id) {
        ApiResponse<Food> response = new ApiResponse<>();
        try{
            response.setResult(foodService.findFoodById(id));
            response.setMsg("find by id success");
        }catch(Exception e){
            response.setMsg("find by id failed");
        }
        return response;
    }

    @GetMapping("/getAll")
    public ApiResponse<List<Food>> getAll() {
        ApiResponse<List<Food>> response = new ApiResponse<>();
        try{
            response.setResult(foodService.findAllFood());
            response.setMsg("find all success");
        }catch (Exception e){
            response.setMsg("find all failed");
        }
        return response;
    }

    @PostMapping("/create")
    public ApiResponse<Food> create(@RequestBody FoodCreationRequest food) {
        ApiResponse<Food> response = new ApiResponse<>();
        try{
            response.setResult(foodService.createFood(food));
            response.setMsg("create success");
        }catch (Exception e){
            response.setMsg("create failed");
        }
        return response;
    }
}
