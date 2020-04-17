package com.epam.oleg.client.client;

import com.epam.oleg.client.dto.UserDTO;
import com.epam.oleg.client.dto.UserSearchRequest;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UserClient extends WebServiceGatewaySupport {

    public GetUserResponse getUserById(String id) {
        GetUserRequest request = new GetUserRequest();
        request.setId(id);

        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetUsersResponse getUsers(UserSearchRequest request) {
        GetUsersRequest getUsersRequest = new GetUsersRequest();
        getUsersRequest.setAge(request.getAge());
        getUsersRequest.setBalance(request.getBalance());
        getUsersRequest.setCity(request.getCity());
        getUsersRequest.setEmail(request.getEmail());
        final String gender = request.getGender();
        getUsersRequest.setGender(gender == null ? null : Gender.fromValue(gender));
        getUsersRequest.setName(getUsersRequest.getName());
        final String userRole = request.getUserRole();
        getUsersRequest.setUserRole(userRole == null ? null : UserRole.fromValue(userRole));
        return (GetUsersResponse) getWebServiceTemplate().marshalSendAndReceive(getUsersRequest);
    }

    public GetUserResponse createUser(UserDTO req) {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setAge(req.getAge());
        createUserRequest.setBalance(req.getBalance());
        createUserRequest.setCity(req.getCity());
        createUserRequest.setEmail(req.getEmail());
        final String gender = req.getGender();
        createUserRequest.setGender(gender == null ? null : Gender.fromValue(gender));
        createUserRequest.setName(req.getName());
        createUserRequest.setPassword(req.getPassword());
        final String userRole = req.getUserRole();
        createUserRequest.setUserRole(userRole == null ? null : UserRole.fromValue(userRole));
        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(createUserRequest);
    }

    public GetUserResponse updateUser(UserDTO req) {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setId(req.getId());
        updateUserRequest.setAge(req.getAge());
        updateUserRequest.setBalance(req.getBalance());
        updateUserRequest.setCity(req.getCity());
        updateUserRequest.setEmail(req.getEmail());
        final String gender = req.getGender();
        updateUserRequest.setGender(gender == null ? null : Gender.fromValue(gender));
        updateUserRequest.setName(req.getName());
        final String userRole = req.getUserRole();
        updateUserRequest.setUserRole(userRole == null ? null : UserRole.fromValue(userRole));

        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(updateUserRequest);
    }

    public DeleteUserResponse delete(String id) {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setId(id);
        return (DeleteUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
