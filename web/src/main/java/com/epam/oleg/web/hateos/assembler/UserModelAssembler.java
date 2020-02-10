package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.web.hateos.model.UserModel;
import com.epam.oleg.web.rest.controller.UserController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {

    public UserModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User entity) {
        return null;
    }
}
