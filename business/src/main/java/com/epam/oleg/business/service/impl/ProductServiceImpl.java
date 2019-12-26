package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.ProductRepository;
import com.epam.oleg.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        Optional<Product> productDTO = productRepository.findById(id);
        return productDTO.orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        throw new NotFoundException("Can't update product with id" + product.getId() + " entity not found");
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
