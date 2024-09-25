package org.example.quan_ly_bida_backend.exception;

import org.example.quan_ly_bida_backend.dto.request.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalException {

    //handle if user enter duplicate data with data in database
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    ResponseEntity<ApiResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMsg("duplicate data");

        return ResponseEntity.badRequest().body(apiResponse);
    }
}
