package com.epam.oleg.training_project.rest.vo;

import com.epam.oleg.training_project.entities.UserRole;
import lombok.Data;

@Data
public class UserVO {
    private String id;
    private String name;
    private UserRole userRole;
}
