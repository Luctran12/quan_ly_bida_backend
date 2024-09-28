package org.example.quan_ly_bida_backend.dto.request;

import lombok.Data;

@Data
public class FoodCreationRequest {
    private String name;
    private Long cost;
    private String imageUrl;
}
