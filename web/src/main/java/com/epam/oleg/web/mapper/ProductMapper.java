package com.epam.oleg.web.mapper;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.web.rest.vo.ProductVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {
    Product toEntity(ProductVO productVO);

    ProductVO toProductVO(Product product);
}
