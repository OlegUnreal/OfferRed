package com.epam.oleg.business.repository.impl;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
