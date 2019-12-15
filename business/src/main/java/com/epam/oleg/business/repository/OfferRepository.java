package com.epam.oleg.business.repository;

import com.epam.oleg.business.repository.dto.OfferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferDTO, String> {
}
