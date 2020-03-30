package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.service.ProductService;
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
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final ProductService productService;
    private final UserService userService;
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    public GetProductResponse getProductById(@RequestPayload GetProductRequest req) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(mapper.map(productService.getById(req.getId()), Product.class));
        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest req) {
        GetProductsResponse response = new GetProductsResponse();
        response.getProductList().addAll(productService.findAll(req.getName(),
                com.epam.oleg.business.entities.ProductCategory.valueOf(req.getCategory().value()),
                req.getPrice(),
                req.getOwnerId())
                .stream()
                .map(e -> mapper.map(e, Product.class)).collect(Collectors.toList()));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductRequest")
    public GetProductResponse createProduct(@RequestPayload CreateProductRequest req) {
        GetProductResponse response = new GetProductResponse();
        com.epam.oleg.business.entities.Product product = new com.epam.oleg.business.entities.Product();
        product.setCategory(com.epam.oleg.business.entities.ProductCategory.valueOf(req.getCategory().value()));
        product.setName(req.getName());
        product.setProductOwner(userService.getById(req.getOwnerId()));
        product.setPrice(req.getPrice());

        response.setProduct(mapper.map(productService.create(product), Product.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest")
    public GetProductResponse updateProduct(@RequestPayload CreateProductRequest req) {
        GetProductResponse response = new GetProductResponse();
        com.epam.oleg.business.entities.Product product = new com.epam.oleg.business.entities.Product();
        product.setCategory(com.epam.oleg.business.entities.ProductCategory.valueOf(req.getCategory().value()));
        product.setName(req.getName());
        product.setProductOwner(userService.getById(req.getOwnerId()));
        product.setPrice(req.getPrice());

        response.setProduct(mapper.map(productService.create(product), Product.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    public void deleteProduct(@RequestPayload DeleteProductRequest req) {
        productService.delete(req.getId());
    }
}
