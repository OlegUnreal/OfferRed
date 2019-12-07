package com.epam.oleg.training_project.service;

import com.epam.oleg.training_project.entities.Product;
import com.epam.oleg.training_project.rest.vo.ProductVO;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(String id);

    Product create(ProductVO productVO);

    Product update(ProductVO productVO);

    void delete(String id);
}
