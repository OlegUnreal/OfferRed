package com.epam.oleg.soapclient.client;

import com.epam.oleg.soapclient.dto.UserDTO;
import com.epam.oleg.soapclient.dto.UserSearchRequest;
import com.oleg.epam.soapclient.*;
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
        getUsersRequest.setGender(Gender.fromValue(request.getGender()));
        getUsersRequest.setName(getUsersRequest.getName());
        getUsersRequest.setUserRole(UserRole.fromValue(request.getUserRole()));
        return (GetUsersResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetUserResponse createUser(UserDTO req) {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setAge(req.getAge());
        createUserRequest.setBalance(req.getBalance());
        createUserRequest.setCity(req.getCity());
        createUserRequest.setEmail(req.getEmail());
        createUserRequest.setGender(Gender.fromValue(req.getGender()));
        createUserRequest.setName(req.getName());
        createUserRequest.setPassword(req.getPassword());
        createUserRequest.setUserRole(UserRole.fromValue(req.getUserRole()));
        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public GetUserResponse updateUser(UserDTO req) {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setId(req.getId());
        updateUserRequest.setAge(req.getAge());
        updateUserRequest.setBalance(req.getBalance());
        updateUserRequest.setCity(req.getCity());
        updateUserRequest.setEmail(req.getEmail());
        updateUserRequest.setGender(Gender.fromValue(req.getGender()));
        updateUserRequest.setName(req.getName());
        updateUserRequest.setUserRole(UserRole.fromValue(req.getUserRole()));

        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public DeleteUserResponse delete(String id) {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setId(id);
        return (DeleteUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
