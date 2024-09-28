package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.StatusCreationRequest;
import org.example.quan_ly_bida_backend.model.Order;
import org.example.quan_ly_bida_backend.model.OrderFoodItem;
import org.example.quan_ly_bida_backend.model.Status;
import org.example.quan_ly_bida_backend.repository.BilliardTableRepo;
import org.example.quan_ly_bida_backend.repository.OrderFoodItemRepo;
import org.example.quan_ly_bida_backend.repository.OrderRepo;
import org.example.quan_ly_bida_backend.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepo statusRepository;

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    OrderFoodItemRepo orderFoodItemRepository;

    @Autowired
    BilliardTableRepo billiardTableRepo;

    // Retrieve all statuses
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    // Retrieve a status by ID
    public Status getStatusById(int id) {
        return statusRepository.findById(id);
    }


    public Status saveStatus(StatusCreationRequest statusCreationRequest) {
        Status status = new Status();

        status.setBilliardTable(billiardTableRepo.findById(statusCreationRequest.getBilliardTableId()).get());
        System.out.println("Status: " + status.getBilliardTable());
        status.setStartTime(statusCreationRequest.getStartTime());
        status.setEndTime(statusCreationRequest.getEndTime());
        status.setTotalTime(statusCreationRequest.getTotalTime());
        System.out.println("Status: setTime complete");

        // create order
//        Order order = new Order();
//        order.setTotalCost(statusCreationRequest.getOrder().getTotalCost());
//        status.setOrder(orderRepository.save(order));

        status.setOrder(orderRepository.findById(statusCreationRequest.getOrderId()).get());
        System.out.println("Status: setOrder complete");
        status.setTotalCost(calculateTotalCost(status));
        status.setDate(statusCreationRequest.getDate());
        System.out.println("complete");
        statusRepository.save(status);
        System.out.println(status.toString() + ":" + statusCreationRequest.toString());
        return status;
    }


    // Delete a status by ID
    public void deleteStatus(int id) {
        statusRepository.deleteById(id);
    }

    // Calculate total cost based on startTime, endTime, and order
    public Double calculateTotalCost(Status status) {
        LocalTime startTime = status.getStartTime();
        LocalTime endTime = status.getEndTime();

        // Sử dụng Duration để tính chênh lệch thời gian
        Duration duration = Duration.between(startTime, endTime);
        double durationInHours = duration.toMinutes() / 60.0; // Chuyển đổi phút thành giờ

        // Chi phí chơi billiard theo giờ
        double billiardsCostPerHour = 10.0;
        double totalCost = durationInHours * billiardsCostPerHour;

        // Tính thêm chi phí order nếu có
        if (status.getOrder() != null) {
            totalCost += status.getOrder().getTotalCost(); // Giả định rằng Order có phương thức getTotalCost()
        }

        // Thiết lập tổng chi phí cho Status


        // Lưu Status và trả về
        return totalCost;
    }

}
