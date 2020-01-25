package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.UserRole;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @NotNull(message = "Id cannot be null")
    @NotEmpty(message = "Id cannot be empty")
    private String id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "User role cannot be null")
    private UserRole userRole;

    @Min(value = 0, message = "Age cannot be less than 0")
    private int age;
    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @NotNull(message = "City cannot be null")
    @NotEmpty(message = "City cannot be empty")
    private String city;
}
