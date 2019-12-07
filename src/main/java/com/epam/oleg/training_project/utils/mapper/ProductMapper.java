package com.epam.oleg.training_project.utils.mapper;

import com.epam.oleg.training_project.entities.Product;
import com.epam.oleg.training_project.rest.vo.ProductVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {
    Product toEntity(ProductVO productVO);

    ProductVO toProductVO(Product product);
}
