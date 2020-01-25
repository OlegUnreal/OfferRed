package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.UserRole;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.web.rest.vo.ProductDTO;
import com.epam.oleg.web.rest.vo.UserDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

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
    public Product createProduct(@Valid @RequestBody ProductDTO productDTO) {
        //should be taken from security credentials, and repository
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setName("Oleg");
        userDTO.setUserRole(UserRole.ADMIN);
        userDTO.setGender(Gender.MALE);
        userDTO.setCity("Lviv");
        productDTO.setProductOwner(userDTO);
        Product product = DozerBeanMapperBuilder.buildDefault()
                .map(productDTO, Product.class);
        return productService.create(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable String id, @Valid @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        Product product = DozerBeanMapperBuilder.buildDefault()
                .map(productDTO, Product.class);
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Product successfully deleted")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
