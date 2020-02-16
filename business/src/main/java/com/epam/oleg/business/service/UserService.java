package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.entities.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll(String email, String name, UserRole userRole, Gender gender, String city, Integer age);

    User getById(String id);

    User getByEmail(String email);

    User create(User user);

    User update(User user);

    void delete(String id);
}
