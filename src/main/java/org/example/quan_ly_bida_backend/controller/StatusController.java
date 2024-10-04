package org.example.quan_ly_bida_backend.controller;

import org.example.quan_ly_bida_backend.dto.request.DateRequest;
import org.example.quan_ly_bida_backend.dto.request.StatusCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.model.Status;
import org.example.quan_ly_bida_backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("/create")
    public ApiResponse<Status> createStatus(@RequestBody StatusCreationRequest status) {
        ApiResponse<Status> respone = new ApiResponse<>();
        try{
            System.out.println("Controller " + status.toString());
            respone.setResult(statusService.saveStatus(status));
            respone.setMsg("create status success");
        }catch (Exception e) {
            respone.setMsg("create status failed: " + e.getMessage());
        }
        return respone;
    }

    @GetMapping("/findAll")
    public ApiResponse<List<Status>> findAllStatus() {
        ApiResponse<List<Status>> respone = new ApiResponse<>();
        try{
            respone.setResult(statusService.getAllStatuses());
            respone.setMsg("findAllStatus success");
        }catch (Exception e) {
            respone.setMsg("findAllStatus failed: " + e.getMessage());
        }
        return respone;
    }

    @GetMapping("/findByDate")
    public ApiResponse<List<Status>> findByDate(@RequestBody DateRequest date) {
        ApiResponse<List<Status>> respone = new ApiResponse<>();
        try {
            respone.setResult(statusService.getByDate(date));
            respone.setMsg("findByDate success");
        }catch (Exception e) {
            respone.setMsg("findByDate failed: " + e.getMessage());
        }
        return respone;
    }
}
