package org.example.quan_ly_bida_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_fullname", nullable = false)
    private String fullName;

    @OneToOne
    @JoinColumn(name= "role_id")
    private Role role;

    public User(User u) {
        this.id = u.id;
        this.username = u.username;
        this.password = u.password;
        this.fullName = u.fullName;
        this.role = u.role;
    }
}
