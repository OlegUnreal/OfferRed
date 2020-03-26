package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
@AllArgsConstructor
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final ProductService productService;
}
