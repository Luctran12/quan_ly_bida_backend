package org.example.quan_ly_bida_backend.dto.request;

import lombok.Data;

@Data
public class BilliardtableCreationRequest {

    private String type;
    private Long costPerHour;

}
