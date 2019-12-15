package com.epam.oleg.business.mapper;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.repository.dto.ProductDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

public class ProductMapper {
    public static Product toEntity(ProductDTO productDTO) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(productDTO, Product.class);
    }

    public static ProductDTO toDto(Product product) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(product, ProductDTO.class);
    }
}
