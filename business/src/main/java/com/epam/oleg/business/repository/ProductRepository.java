package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();

    Product getById(String id);

    Product create(Product product);

    Product update(Product product);

    void delete(String id);
}
