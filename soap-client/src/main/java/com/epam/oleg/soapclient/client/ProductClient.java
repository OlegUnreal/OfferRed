package com.epam.oleg.soapclient.client;

import com.epam.oleg.soapclient.dto.ProductDTO;
import com.epam.oleg.soapclient.dto.ProductSearchRequest;
import com.oleg.epam.soapclient.*;
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
        getProductsRequest.setCategory(ProductCategory.fromValue(req.getCategory()));
        getProductsRequest.setOwnerId(req.getOwnerId());
        getProductsRequest.setPrice(req.getPrice());
        return (GetProductsResponse) getWebServiceTemplate().marshalSendAndReceive(getProductsRequest);
    }

    public GetProductResponse createProduct(ProductDTO req) {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setCategory(ProductCategory.fromValue(req.getCategory()));
        createProductRequest.setName(req.getName());
        createProductRequest.setOwnerId(req.getOwnerId());
        createProductRequest.setPrice(req.getPrice());

        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public GetProductResponse updateProduct(ProductDTO req) {
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setId(req.getId());
        updateProductRequest.setCategory(ProductCategory.fromValue(req.getCategory()));
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
