package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.UserRole;
import lombok.Data;

@Data
public class UserVO {
    private String id;
    private String name;
    private UserRole userRole;
}
