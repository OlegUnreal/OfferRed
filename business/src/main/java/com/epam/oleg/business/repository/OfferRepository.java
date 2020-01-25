package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

    Page<Offer> getAllByOfferStatus(OfferStatus offerStatus, Pageable page);
}
