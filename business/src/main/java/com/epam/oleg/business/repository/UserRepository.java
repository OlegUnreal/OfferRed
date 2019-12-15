package com.epam.oleg.business.repository;

import com.epam.oleg.business.repository.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, String> {
}
