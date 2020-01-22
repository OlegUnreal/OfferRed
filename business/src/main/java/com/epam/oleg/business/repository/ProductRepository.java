package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByName(String name);

    Page<Product> findAllByCategory(ProductCategory productCategory);

    Page<Product> findAllByPrice(int price);

}
