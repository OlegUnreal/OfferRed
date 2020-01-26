package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Page<User> getAll(Pageable pageable);

    User getById(String id);

    User getByEmail(String email);

    User create(User user);

    User update(User user);

    void delete(String id);
}
