package com.epam.oleg.client.dto;

import lombok.Data;

@Data
public class UserSearchRequest {
    private String email;
    private String name;
    private String userRole;
    private String gender;
    private String city;
    private int age;
    private int balance;
}
