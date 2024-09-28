package org.example.quan_ly_bida_backend.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequest {
    @Size(min=4,max=20)
    private String userName;
    @Size(min=5,max=20)
    private String password;
}
