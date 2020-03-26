package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.service.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
@AllArgsConstructor
public class OfferEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final OfferService offerService;
}
