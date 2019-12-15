package com.epam.oleg.business.repository;

import com.epam.oleg.business.repository.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, String> {

}
