package com.olegkornii.soap.soap.endpoint;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.service.impl.UserServiceImpl;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class UserEndpoint {

    private final UserServiceImpl userService;

    @PayloadRoot(namespace = "http://localhost:8080/xml/users", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getCountry(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = userService.getByEmail(request.getUser().getEmail());
        response.setUser(DozerBeanMapperBuilder.buildDefault()
                .map(user, io.spring.guides.gs_producing_web_service.User.class));

        return response;
    }
}
