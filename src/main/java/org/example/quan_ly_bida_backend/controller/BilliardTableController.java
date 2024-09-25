package org.example.quan_ly_bida_backend.controller;

import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.example.quan_ly_bida_backend.dto.request.BilliardtableCreationRequest;
import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.example.quan_ly_bida_backend.model.BilliardTable;
import org.example.quan_ly_bida_backend.service.BilliardTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billiard_table")
public class BilliardTableController {

    @Autowired
    BilliardTableService billiardTableService;

    @PostMapping("/create")
    public ApiResponse<BilliardTable>  createBilliardTable(@RequestBody @Valid BilliardtableCreationRequest billiardTable) {
        ApiResponse<BilliardTable> response = new ApiResponse<BilliardTable>();

        response.setMsg("create table successfully");
        response.setResult(billiardTableService.addTable(billiardTable));

        System.out.println("Controller " + response.getResult());
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Integer> deleteBilliardTable(@PathVariable int id) {
        ApiResponse<Integer> respone = new ApiResponse<>();

        respone.setResult(billiardTableService.deleteTable(id));
        respone.setMsg("delete success");
        return respone;
    }

    @GetMapping("/getAllTable")
    public ApiResponse<List<BilliardTable>> getAllTable() {
        ApiResponse<List<BilliardTable>> response = new ApiResponse<>();
        response.setResult(billiardTableService.getAllTable());
        response.setMsg("getAllTable success");
        return response;
    }
}
