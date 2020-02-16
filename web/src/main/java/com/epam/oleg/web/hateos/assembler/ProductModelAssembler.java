package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.web.hateos.model.ProductModel;
import com.epam.oleg.web.rest.controller.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {

    private final UserModelAssembler userModelAssembler;

    @Autowired
    public ProductModelAssembler(UserModelAssembler userModelAssembler) {
        super(ProductController.class, ProductModel.class);
        this.userModelAssembler = userModelAssembler;
    }

    @Override
    public ProductModel toModel(Product entity) {
        ProductModel productModel = instantiateModel(entity);
        productModel.add(linkTo(methodOn(ProductController.class)
                .getProduct(entity.getId()))
                .withSelfRel());
        productModel.setId(entity.getId());
        productModel.setCategory(entity.getCategory());
        productModel.setName(entity.getName());
        productModel.setPrice(entity.getPrice());
        productModel.setProductOwner(userModelAssembler.toModel(entity.getProductOwner()));

        return productModel;
    }

    @Override
    public CollectionModel<ProductModel> toCollectionModel(Iterable<? extends Product> entities) {
        CollectionModel<ProductModel> productModels = super.toCollectionModel(entities);
        productModels.add(linkTo(methodOn(ProductController.class)
                .getAll(null, null, null, null, null))
                .withSelfRel()
                .expand());
        return productModels;
    }
}
