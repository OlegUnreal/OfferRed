package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.web.mapper.dozer.ProductMapper;
import com.epam.oleg.web.rest.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> getAll(@PageableDefault Pageable pageable) {
        return productService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@Valid @RequestBody ProductVO productVO) {
        Product product = ProductMapper.toEntity(productVO);
        return productService.create(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable String id, @Valid @RequestBody ProductVO productVO) {
        productVO.setId(id);
        Product product = ProductMapper.toEntity(productVO);
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Product successfully deleted")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
