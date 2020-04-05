package com.epam.oleg.soapclient.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String email;
    private String password;
    private String name;
    private String userRole;
    private String gender;
    private String city;
    private int age;
    private int balance;
}
