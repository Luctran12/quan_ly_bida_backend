package org.example.quan_ly_bida_backend.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class StatusCreationRequest {
    private Long orderId;
    private int billiardTableId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime totalTime;
    private LocalDate date;
}
