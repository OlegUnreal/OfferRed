package com.epam.oleg.business.repository;

import com.epam.oleg.business.repository.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, String> {

}
