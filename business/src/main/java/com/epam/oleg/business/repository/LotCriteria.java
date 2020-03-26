package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.business.entities.LotStatus;
import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

@Repository
@AllArgsConstructor
public class LotCriteria {
    private final EntityManager entityManager;

    public List<Lot> findAll(Integer startedPrice, Integer currentPrice, Integer finalPrice, LotStatus status,
                             String offerId, String ownerId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lot> cq = cb.createQuery(Lot.class);
        Root<Lot> lot = cq.from(Lot.class);

        if (startedPrice != null) {
            Predicate startedPricePredicate = cb.equal(lot.get("startedPrice"), startedPrice);
            cq.where(startedPricePredicate);
        }
        if (currentPrice != null) {
            Predicate currentPricePredicate = cb.equal(lot.get("currentPrice"), currentPrice);
            cq.where(currentPricePredicate);
        }
        if (finalPrice != null) {
            Predicate finalPricePredicate = cb.equal(lot.get("finalPrice"), finalPrice);
            cq.where(finalPricePredicate);
        }
        if (status != null) {
            Predicate statusPredicate = cb.equal(lot.get("status"), status);
            cq.where(statusPredicate);
        }
        if (isNotEmpty(ownerId)) {
            Join<Lot, User> lotOwnerJoin = lot.join("lotOwner", JoinType.LEFT);
            lotOwnerJoin.on(cb.equal(lotOwnerJoin.get("id"), ownerId));
            cq.where(lotOwnerJoin.getOn());
        }
        if (isNotEmpty(offerId)) {
            Join<Lot, Offer> lotOfferJoin = lot.join("offer", JoinType.LEFT);
            lotOfferJoin.on(cb.equal(lotOfferJoin.get("id"), offerId));
            cq.where(lotOfferJoin.getOn());
        }
        TypedQuery<Lot> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
