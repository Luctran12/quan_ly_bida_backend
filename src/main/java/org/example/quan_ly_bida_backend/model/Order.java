package org.example.quan_ly_bida_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "billiard_order")
@Getter
@Setter

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "status_id")
//    private Status status;

    @OneToOne(mappedBy = "order") // This indicates the relationship is managed by the 'order' field in Status
    @JsonIgnore
    private Status status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)

    private Set<OrderFoodItem> orderFoodItems = new HashSet<>();

    @Column(name = "total_cost")
    private Long totalCost;

    public Long calculateTotalCost() {
        Long total = 0L;
        for (OrderFoodItem orderFoodItem : orderFoodItems) {
            total = total + (orderFoodItem.getQuantity() * orderFoodItem.getFood().getCost());
        }
        return total;
    }
}
