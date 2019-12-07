package com.epam.oleg.training_project.rest.controller;

import com.epam.oleg.training_project.entities.Product;
import com.epam.oleg.training_project.rest.vo.ProductVO;
import com.epam.oleg.training_project.service.ProductService;
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
        return ResponseEntity.ok(productService.create(productVO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductVO productVO) {
        productVO.setId(id);
        return ResponseEntity.ok(productService.update(productVO));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Product successfully deleted")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
