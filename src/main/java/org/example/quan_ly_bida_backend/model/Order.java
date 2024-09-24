package org.example.quan_ly_bida_backend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "billiard_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "order")
    private Set<OrderFoodItem> orderFoodItems = new HashSet<>();

    @Column(name = "total_cost")
    private Long totalCost;

}
