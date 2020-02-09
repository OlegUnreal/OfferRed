package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.repository.ProductCriteria;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.business.service.UserService;
import com.epam.oleg.web.rest.controller.auth.utils.AuthUtils;
import com.epam.oleg.web.rest.dto.ProductDTO;
import com.epam.oleg.web.rest.dto.UserDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private UserService userService;
    private ProductCriteria productCriteria;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll(@PageableDefault Pageable pageable,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) Integer price,
                                @RequestParam(required = false) String productOwner) {
        return productCriteria.findAll(name, category, price, productOwner);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@Valid @RequestBody ProductDTO productDTO) {
        User user = userService.getByEmail(AuthUtils.getCurrentAuth().getName());
        productDTO.setProductOwner(DozerBeanMapperBuilder.buildDefault()
                .map(user, UserDTO.class));
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
