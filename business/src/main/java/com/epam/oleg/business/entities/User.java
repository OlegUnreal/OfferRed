package com.epam.oleg.business.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String id;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    @Column(nullable = false)
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String city;
    private int age;
}
