package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Product;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductCriteria {

    private final EntityManager entityManager;

    public List<Product> findAll(String name, String category, Integer price, String productOwner) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = criteriaBuilder.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        if (StringUtils.isNotEmpty(name)) {
            Predicate namePredicate = criteriaBuilder.equal(product.get("name"), name);
            cq.where(namePredicate);
        }
        if (StringUtils.isNotEmpty(category)) {
            Predicate categoryPredicate = criteriaBuilder.equal(product.get("category"), category);
            cq.where(categoryPredicate);
        }
        if (price != null) {
            Predicate pricePredicate = criteriaBuilder.equal(product.get("price"), price);
            cq.where(pricePredicate);
        }
        if (StringUtils.isNotEmpty(productOwner)) {
        }
        TypedQuery<Product> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
