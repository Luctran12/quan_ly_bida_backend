package org.example.quan_ly_bida_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oder_food_items")
@Setter
@Getter
public class OrderFoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne()
    @JoinColumn(name="table_id")
    private BilliardTable table;

}
