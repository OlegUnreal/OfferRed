package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.ProductRepository;
import com.epam.oleg.business.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
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
