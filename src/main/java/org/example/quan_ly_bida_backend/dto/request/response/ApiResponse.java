package org.example.quan_ly_bida_backend.dto.request.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private int code;
    private String msg;
    private T result;


}