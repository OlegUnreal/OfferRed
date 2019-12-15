package com.epam.oleg.web.mapper.dozer;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.web.rest.vo.ProductVO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

public class ProductMapper {

    public static Product toEntity(ProductVO productVO) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(productVO, Product.class);
    }
}
