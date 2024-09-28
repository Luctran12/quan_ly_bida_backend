package org.example.quan_ly_bida_backend.controller;

import org.example.quan_ly_bida_backend.dto.request.StatusCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.model.Status;
import org.example.quan_ly_bida_backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
