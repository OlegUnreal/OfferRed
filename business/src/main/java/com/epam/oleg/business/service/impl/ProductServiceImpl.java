package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.mapper.OfferMapper;
import com.epam.oleg.business.mapper.ProductMapper;
import com.epam.oleg.business.repository.ProductRepository;
import com.epam.oleg.business.repository.dto.ProductDTO;
import com.epam.oleg.business.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Product getById(String id) {
        Optional<ProductDTO> productDTO = productRepository.findById(id);
        return productDTO.map(ProductMapper::toEntity).orElse(null);
    }

    @Override
    public Product create(Product product) {
        ProductDTO productDTO = productRepository.save(ProductMapper.toDto(product));
        return ProductMapper.toEntity(productDTO);
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getId())) {
            return ProductMapper.toEntity(productRepository.save(ProductMapper.toDto(product)));
        }
        //Exception should be thrown
        return null;
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
