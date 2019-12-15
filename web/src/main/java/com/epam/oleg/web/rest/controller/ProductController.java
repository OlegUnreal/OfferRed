package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.web.mapper.dozer.ProductMapper;
import com.epam.oleg.web.rest.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductVO productVO) {
        Product product = ProductMapper.toEntity(productVO);
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductVO productVO) {
        productVO.setId(id);
        Product product = ProductMapper.toEntity(productVO);
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Product successfully deleted")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
