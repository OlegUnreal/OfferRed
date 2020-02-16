package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> findAll(String name, String category, Integer price, String productOwner);

    Product getById(String id);

    Product create(Product product);

    Product update(Product product);

    void delete(String id);
}
