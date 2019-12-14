package com.epam.oleg.training_project.entities;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private UserRole userRole;
}
