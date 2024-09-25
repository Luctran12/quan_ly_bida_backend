package org.example.quan_ly_bida_backend.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BilliardtableCreationRequest {

    private String type;
    @NotNull(message = "cost must not empty")
    private Long costPerHour;

}
