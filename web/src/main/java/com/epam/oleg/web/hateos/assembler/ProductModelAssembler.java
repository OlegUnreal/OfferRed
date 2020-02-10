package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.web.hateos.model.ProductModel;
import com.epam.oleg.web.rest.controller.ProductController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {

    public ProductModelAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(Product entity) {
        return null;
    }
}
