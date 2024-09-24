package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.BilliardtableCreationRequest;
import org.example.quan_ly_bida_backend.model.BilliardTable;
import org.example.quan_ly_bida_backend.repository.BilliardTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilliardTableService {

    @Autowired
    BilliardTableRepo billiardTableRepo;

    public BilliardTable addTable( BilliardtableCreationRequest billiardTable) {
        BilliardTable b = new BilliardTable();
        b.setType(billiardTable.getType());
        b.setCostPerHour(billiardTable.getCostPerHour());

        return billiardTableRepo.save(b);
    }

    public void deleteTable( int id) {
        billiardTableRepo.deleteById(id);
    }
}
