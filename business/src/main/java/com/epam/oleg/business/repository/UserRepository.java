package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User getById(String id);

    User create(User user);

    User update(User user);

    void delete(String id);
}
