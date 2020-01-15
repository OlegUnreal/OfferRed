package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Page<Product> getAll(Pageable pageable);

    Product getById(String id);

    Product create(Product product);

    Product update(Product product);

    void delete(String id);
}
