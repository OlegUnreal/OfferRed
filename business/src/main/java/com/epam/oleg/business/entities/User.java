package com.epam.oleg.business.entities;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private UserRole userRole;
}
