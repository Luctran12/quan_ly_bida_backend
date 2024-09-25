package org.example.quan_ly_bida_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreationRequest {
    private String userName;
    private String password;
    private String fullName;
}
