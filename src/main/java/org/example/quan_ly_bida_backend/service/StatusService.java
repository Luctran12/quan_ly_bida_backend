package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.dto.request.DateRequest;
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
import java.time.LocalDate;
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

    @Autowired
    OrderService orderService;


    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }


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

        //re calculate totalcost for oder
        Order order = orderRepository.findById(statusCreationRequest.getOrderId()).get();

        orderService.orderTotalCost(order.getId());

        status.setOrder(order);
        System.out.println("Status: setOrder complete");

        Double total = calculateTotalCost(status);
        status.setTotalCost(total);
        status.setDate(statusCreationRequest.getDate());
        System.out.println("complete");
        statusRepository.save(status);
        System.out.println(status.toString() + ":" + statusCreationRequest.toString());
        return status;
    }


    public void deleteStatus(int id) {
        statusRepository.deleteById(id);
    }

    public List<Status> getByDate(DateRequest datereq) {
        LocalDate date = LocalDate.of(datereq.getYear(),datereq.getMonth(),datereq.getDay());
        return statusRepository.findByDate(date);
    }

    public Double calculateTotalCost(Status status) {
        LocalTime startTime = status.getStartTime();
        LocalTime endTime = status.getEndTime();

        // Sử dụng Duration để tính chênh lệch thời gian
        Duration duration = Duration.between(startTime, endTime);
        double durationInHours = duration.toMinutes() / 60.0; // Chuyển đổi phút thành giờ

        // Chi phí chơi billiard theo giờ
        double billiardsCostPerHour = status.getBilliardTable().getCostPerHour();
        double totalCost = durationInHours * billiardsCostPerHour;

        // Tính thêm chi phí order nếu có
        if (status.getOrder() != null) {
            totalCost += status.getOrder().calculateTotalCost();
        }
        return totalCost;
    }

}
