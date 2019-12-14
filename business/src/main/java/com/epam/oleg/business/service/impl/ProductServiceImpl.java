package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.repository.ProductRepository;
import com.epam.oleg.business.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(String id) {
        return productRepository.getById(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }
}
