package org.example.quan_ly_bida_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "oder_food_items")
public class OrderFoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="table_id")
    private BilliardTable table;
}
