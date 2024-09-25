package org.example.quan_ly_bida_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Billiard_Tables")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BilliardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "billiard_table_type")
    private String type;

    @Column(name = "billiard_table_cost_per_hour")
    private Long costPerHour;




}
