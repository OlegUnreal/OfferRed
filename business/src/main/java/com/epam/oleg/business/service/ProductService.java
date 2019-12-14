package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAll();

    Product getById(String id);

    Product create(Product product);

    Product update(Product product);

    void delete(String id);
}
