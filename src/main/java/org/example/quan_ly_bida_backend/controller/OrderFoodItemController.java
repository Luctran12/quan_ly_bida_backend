package org.example.quan_ly_bida_backend.controller;

import org.example.quan_ly_bida_backend.dto.request.OrderFoodItemCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.model.OrderFoodItem;
import org.example.quan_ly_bida_backend.service.OrderFoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderFoodItem")
public class OrderFoodItemController {

    @Autowired
    OrderFoodItemService orderFoodItemService;

    @GetMapping("/findByTableId/{id}")
    public ApiResponse<List<OrderFoodItem>> findByTableId(@PathVariable int id) {
        ApiResponse<List<OrderFoodItem>>  response = new ApiResponse<>();
        response.setResult(orderFoodItemService.findByTableId(id));
        response.setMsg("find by table id success");
        return response;
    }

    @PostMapping("/create")
    public ApiResponse<OrderFoodItem> create(@RequestBody OrderFoodItemCreationRequest orderFoodItem) {
        ApiResponse<OrderFoodItem>  response = new ApiResponse<>();
        response.setResult(orderFoodItemService.createOrderFoodItem(orderFoodItem));
        response.setMsg("create order food item success");
        return response;
    }

    @GetMapping("/getAll")
    public ApiResponse<List<OrderFoodItem>> getAll() {
        ApiResponse<List<OrderFoodItem>>  response = new ApiResponse<>();
        try{
            response.setResult(orderFoodItemService.getAllOrderFoodItems());
            response.setMsg("get all order food items success");
        }catch(Exception e){
            response.setMsg("get all order food items failed");
        }
        return response;
    }

    @PostMapping("/add-OrderTable/{oderFoodItemId}/{orderTableId}")
    public ApiResponse<OrderFoodItem> addOrderTable(@PathVariable int oderFoodItemId, @PathVariable Long orderTableId ) {
        ApiResponse<OrderFoodItem>  response = new ApiResponse<>();
        try{
            response.setResult(orderFoodItemService.addOrderTable(oderFoodItemId, orderTableId));
            response.setMsg("add order food item success");
        }catch(Exception e){
            response.setMsg("add order food item failed");
        }
        return response;
    }
}
