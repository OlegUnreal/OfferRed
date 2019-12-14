package com.epam.oleg.training_project.repository.impl;

import com.epam.oleg.training_project.entities.Product;
import com.epam.oleg.training_project.repository.ProductRepository;
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
