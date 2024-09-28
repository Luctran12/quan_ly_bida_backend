package org.example.quan_ly_bida_backend.controller;

import org.example.quan_ly_bida_backend.dto.request.OrderCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_table")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ApiResponse<Long> create() {
        ApiResponse<Long> response = new ApiResponse<>();
        try {
            response.setResult(orderService.createOrder().getId());
            response.setMsg("Create Order Success");
        }catch (Exception e) {
            response.setMsg("Create Order Failed");
        }
        return response;
    }

    @GetMapping("/getTotalCost/{id}")
    public ApiResponse<Long> getTotalCost(@PathVariable Long id) {
        ApiResponse<Long> response = new ApiResponse<>();
        try{
            response.setResult(orderService.orderTotalCost(id));
            response.setMsg("Get Total Cost Success");
        }catch (Exception e) {
            response.setMsg("Get Total Cost Failed");
        }
        return response;
    }
}
