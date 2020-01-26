package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.entities.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getByName(String name);

    Page<User> findAllBy(UserRole userRole, Pageable page);

    Optional<User> findByEmail(String email);
}
