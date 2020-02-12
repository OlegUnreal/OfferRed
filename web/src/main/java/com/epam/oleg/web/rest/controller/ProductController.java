package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.repository.ProductCriteria;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.business.service.UserService;
import com.epam.oleg.web.hateos.assembler.ProductModelAssembler;
import com.epam.oleg.web.hateos.model.ProductModel;
import com.epam.oleg.web.rest.controller.auth.utils.AuthUtils;
import com.epam.oleg.web.rest.dto.ProductDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private UserService userService;
    private ProductCriteria productCriteria;
    private final ProductModelAssembler assembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<ProductModel> getAll(@PageableDefault Pageable pageable,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) String category,
                                                @RequestParam(required = false) Integer price,
                                                @RequestParam(required = false) String productOwner) {
        return assembler.toCollectionModel(productCriteria.findAll(name, category, price, productOwner));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductModel getProduct(@PathVariable String id) {
        return assembler.toModel(productService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductModel createProduct(@Valid @RequestBody ProductDTO productDTO) {
        User user = userService.getByEmail(AuthUtils.getCurrentAuth().getName());
        Product product = DozerBeanMapperBuilder.buildDefault()
                .map(productDTO, Product.class);
        product.setProductOwner(user);
        return assembler.toModel(productService.create(product));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission(#id, 'PRODUCT','UPDATE')")
    public ProductModel updateProduct(@PathVariable String id, @Valid @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        Product product = DozerBeanMapperBuilder.buildDefault()
                .map(productDTO, Product.class);
        return assembler.toModel(productService.update(product));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasPermission(#id, 'PRODUCT','DELETE')")
    @ResponseStatus(code = HttpStatus.OK, reason = "Product successfully deleted")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
