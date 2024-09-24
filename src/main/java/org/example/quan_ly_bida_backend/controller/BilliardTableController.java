package org.example.quan_ly_bida_backend.controller;

import jakarta.persistence.Table;
import org.example.quan_ly_bida_backend.dto.request.BilliardtableCreationRequest;
import org.example.quan_ly_bida_backend.model.BilliardTable;
import org.example.quan_ly_bida_backend.service.BilliardTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/billiard_table")
public class BilliardTableController {

    @Autowired
    BilliardTableService billiardTableService;

    @PostMapping("/create")
    public BilliardTable createBilliardTable(@RequestBody BilliardtableCreationRequest billiardTable) {
        return billiardTableService.addTable(billiardTable);
    }

    @DeleteMapping("/delete")
    public String deleteBilliardTable(@RequestBody int id) {
        billiardTableService.deleteTable(id);
        return "Deleted";
    }
}
