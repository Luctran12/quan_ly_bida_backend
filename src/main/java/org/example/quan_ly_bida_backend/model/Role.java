package org.example.quan_ly_bida_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;


@Entity
@Table(name = "role")
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private EnumRole role;

    @OneToOne(mappedBy = "role")
    private User user;

    public Role() {}
}
