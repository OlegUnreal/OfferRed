package com.epam.oleg.training_project.service.impl;

import com.epam.oleg.training_project.entities.Product;
import com.epam.oleg.training_project.repository.ProductRepository;
import com.epam.oleg.training_project.rest.vo.ProductVO;
import com.epam.oleg.training_project.service.ProductService;
import com.epam.oleg.training_project.utils.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(String id) {
        return productRepository.getById(id);
    }

    @Override
    public Product create(ProductVO productVO) {
        Product product = productMapper.toEntity(productVO);
        return productRepository.create(product);
    }

    @Override
    public Product update(ProductVO productVO) {
        Product product = productMapper.toEntity(productVO);
        return productRepository.update(product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }
}
