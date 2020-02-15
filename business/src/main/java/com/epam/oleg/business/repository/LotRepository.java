package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot, String> {
}
