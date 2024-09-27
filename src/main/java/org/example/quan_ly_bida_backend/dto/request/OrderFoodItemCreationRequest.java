package org.example.quan_ly_bida_backend.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.quan_ly_bida_backend.model.BilliardTable;
import org.example.quan_ly_bida_backend.model.Food;
import org.example.quan_ly_bida_backend.model.Order;

@Data
public class OrderFoodItemCreationRequest {

    private Food food;


    private int quantity;


    private BilliardTable table;
}
