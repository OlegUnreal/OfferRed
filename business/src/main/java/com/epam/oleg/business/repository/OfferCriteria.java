package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@AllArgsConstructor
public class OfferCriteria {

    private final EntityManager entityManager;

    public List<Offer> findAll(OfferStatus offerStatus, String offerOwner, String productId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Offer> cq = criteriaBuilder.createQuery(Offer.class);
        Root<Offer> offer = cq.from(Offer.class);

        if (offerStatus != null) {
            Predicate offerStatusPredicate = criteriaBuilder.equal(offer.get("offerStatus"), offerStatus);
            cq.where(offerStatusPredicate);
        }

        if (StringUtils.isNotEmpty(offerOwner)) {
            Join<Offer, User> offerUserJoin = offer.join("offerOwner", JoinType.LEFT);
            offerUserJoin.on(criteriaBuilder.equal(offerUserJoin.get("id"), offerOwner));
            cq.where(offerUserJoin.getOn());
        }

        if (StringUtils.isNotEmpty(productId)) {
            Join<Offer, Product> offerProductJoin = offer.join("products", JoinType.LEFT);
            offerProductJoin.on(criteriaBuilder.equal(offerProductJoin.get("id"), productId));
            cq.where(offerProductJoin.getOn());
        }

        TypedQuery<Offer> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
