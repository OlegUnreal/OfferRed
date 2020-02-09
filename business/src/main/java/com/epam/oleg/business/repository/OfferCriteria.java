package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Offer;
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

    public List<Offer> findAll(String offerStatus, String ownerName, String productName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Offer> cq = criteriaBuilder.createQuery(Offer.class);
        Root<Offer> offer = cq.from(Offer.class);

        if (StringUtils.isNotEmpty(offerStatus)) {
            Predicate offerStatusPredicate = criteriaBuilder.equal(offer.get("offerStatus"), offerStatus);
            cq.where(offerStatusPredicate);
        }

        if (StringUtils.isNotEmpty(ownerName)) {
        }

        if(StringUtils.isNotEmpty(productName)) {
        }

        TypedQuery<Offer> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
