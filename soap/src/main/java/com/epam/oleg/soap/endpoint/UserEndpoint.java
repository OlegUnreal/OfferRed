package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.service.UserService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import io.spring.guides.gs_producing_web_service.*;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;

@Endpoint
@AllArgsConstructor
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final UserService userService;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    public GetUserResponse getUserById(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(DozerBeanMapperBuilder.buildDefault().map(userService.getById(request.getId()), User.class));
        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
    public GetUsersResponse getUsers(@RequestPayload GetUsersRequest req) {
        GetUsersResponse response = new GetUsersResponse();
        final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        response.getUserList().addAll(userService.findAll(req.getEmail(),
                req.getName(), com.epam.oleg.business.entities.UserRole.valueOf(req.getUserRole().value()),
                com.epam.oleg.business.entities.Gender.valueOf(req.getGender().value()),
                req.getCity(), req.getAge().intValue())
                .stream()
                .map(e -> mapper.map(e, User.class))
                .collect(Collectors.toList()));
        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    public GetUserResponse createUser(@RequestPayload CreateUserRequest req) {
        GetUserResponse response = new GetUserResponse();
        com.epam.oleg.business.entities.User user = new com.epam.oleg.business.entities.User();
        user.setAge(req.getAge().intValue());
        user.setBalance(req.getBalance());
        user.setCity(req.getCity());
        user.setEmail(req.getEmail());
        user.setGender(com.epam.oleg.business.entities.Gender.valueOf(req.getGender().value()));
        user.setName(req.getName());
        user.setPassword(req.getPassword());
        user.setUserRole(com.epam.oleg.business.entities.UserRole.valueOf(req.getUserRole().value()));

        final com.epam.oleg.business.entities.User createdUser = userService.create(user);
        response.setUser(DozerBeanMapperBuilder.buildDefault().map(createdUser, User.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    public GetUserResponse updateUser(@RequestPayload UpdateUserRequest req) {
        GetUserResponse response = new GetUserResponse();
        com.epam.oleg.business.entities.User user = new com.epam.oleg.business.entities.User();
        user.setId(req.getId());
        user.setAge(req.getAge().intValue());
        user.setBalance(req.getBalance());
        user.setCity(req.getCity());
        user.setEmail(req.getEmail());
        user.setGender(com.epam.oleg.business.entities.Gender.valueOf(req.getGender().value()));
        user.setName(req.getName());
        user.setUserRole(com.epam.oleg.business.entities.UserRole.valueOf(req.getUserRole().value()));
        response.setUser(DozerBeanMapperBuilder.buildDefault().map(userService.update(user), User.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    public DeleteUserResponse delete(@RequestPayload DeleteUserRequest req) {
        DeleteUserResponse response = new DeleteUserResponse();
        userService.delete(req.getId());
        return response;
    }
}
