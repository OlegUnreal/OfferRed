package com.epam.oleg.web.hateos.model;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends RepresentationModel<UserModel> {
    private String id;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    private UserRole userRole;
    private Gender gender;
    private String city;
    private int age;
    private int balance;
}
