package com.epam.oleg.web.rest.dto;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.UserRole;
import com.epam.oleg.web.validation.user.UniqueEmail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @JsonIgnore
    private String id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    @UniqueEmail
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @NotNull(message = "User role cannot be null")
    private UserRole userRole;

    @Min(value = 1, message = "Age cannot be less than 0")
    private int age;
    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @NotNull(message = "City cannot be null")
    @NotEmpty(message = "City cannot be empty")
    private String city;

    @Min(value = 0, message = "Balance cannot be negative")
    private int balance;
}
