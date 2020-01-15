package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.UserRole;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserVO {
    @NotNull(message = "Id cannot be null")
    @NotEmpty(message = "Id cannot be empty")
    private String id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "User role cannot be null")
    private UserRole userRole;
}
