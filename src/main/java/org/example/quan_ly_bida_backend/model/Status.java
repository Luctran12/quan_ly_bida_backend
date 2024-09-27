package org.example.quan_ly_bida_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "billiard_table_id")
    private BilliardTable billiardTable;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date endTime;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date totalTime;

//    @OneToMany(mappedBy = "status",cascade = CascadeType.ALL)
//    private Set<Order> orders = new HashSet<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id", referencedColumnName = "id") // Foreign key column in Status referencing Order
    @JsonIgnore
    private Order order;

    @Column(name = "total")
    private Double totalCost;
}
