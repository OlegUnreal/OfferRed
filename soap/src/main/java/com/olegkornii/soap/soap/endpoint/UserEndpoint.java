package com.olegkornii.soap.soap.endpoint;

import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    public GetUserResponse getCountry(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();

        return response;
    }
}
