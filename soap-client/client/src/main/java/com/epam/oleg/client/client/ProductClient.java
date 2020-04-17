package com.epam.oleg.client.client;

import com.epam.oleg.client.dto.ProductDTO;
import com.epam.oleg.client.dto.ProductSearchRequest;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ProductClient extends WebServiceGatewaySupport {

    public GetProductResponse getProductById(String id) {
        GetProductRequest request = new GetProductRequest();
        request.setId(id);

        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetProductsResponse getProducts(ProductSearchRequest req) {
        GetProductsRequest getProductsRequest = new GetProductsRequest();
        getProductsRequest.setName(req.getName());
        final String category = req.getCategory();
        getProductsRequest.setCategory(category == null ? null : ProductCategory.fromValue(category));
        getProductsRequest.setOwnerId(req.getOwnerId());
        getProductsRequest.setPrice(req.getPrice());
        return (GetProductsResponse) getWebServiceTemplate().marshalSendAndReceive(getProductsRequest);
    }

    public GetProductResponse createProduct(ProductDTO req) {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        final String category = req.getCategory();
        createProductRequest.setCategory(category == null ? null : ProductCategory.fromValue(category));
        createProductRequest.setName(req.getName());
        createProductRequest.setOwnerId(req.getOwnerId());
        createProductRequest.setPrice(req.getPrice());

        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(createProductRequest);
    }

    public GetProductResponse updateProduct(ProductDTO req) {
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setId(req.getId());
        final String category = req.getCategory();
        updateProductRequest.setCategory(category == null ? null : ProductCategory.fromValue(category));
        updateProductRequest.setName(req.getName());
        updateProductRequest.setOwnerId(req.getOwnerId());
        updateProductRequest.setPrice(req.getPrice());

        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(updateProductRequest);
    }

    public void deleteProduct(String id) {
        DeleteProductRequest request = new DeleteProductRequest();
        request.setId(id);
        getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
