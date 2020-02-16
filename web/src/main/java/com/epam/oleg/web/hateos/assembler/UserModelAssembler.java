package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.web.hateos.model.UserModel;
import com.epam.oleg.web.rest.controller.UserController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {

    public UserModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User entity) {

        UserModel userModel = instantiateModel(entity);
        userModel.add(linkTo(methodOn(UserController.class)
                .getUser(entity.getId()))
                .withSelfRel());
        userModel.setId(entity.getId());
        userModel.setAge(entity.getAge());
        userModel.setCity(entity.getCity());
        userModel.setEmail(entity.getEmail());
        userModel.setGender(entity.getGender());
        userModel.setUserRole(entity.getUserRole());
        userModel.setPassword(entity.getPassword());
        userModel.setBalance(entity.getBalance());
        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserModel> userModels = super.toCollectionModel(entities);
        userModels.add(linkTo(methodOn(UserController.class)
                .getAll(null, null, null, null, null, null, null))
                .withSelfRel()
                .expand());
        return userModels;
    }
}
