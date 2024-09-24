package org.example.quan_ly_bida_backend.model;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Billiard_Tables")
@Setter
public class BilliardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "billiard_table_type")
    private String type;

    @Column(name = "billiard_table_cost_per_hour")
    private Long costPerHour;

    @OneToMany(mappedBy = "billiardTable")
    private Set<Status> status = new HashSet<>();

}
