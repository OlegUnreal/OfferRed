package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();

    User getById(String id);

    User create(User user);

    User update(User user);

    void delete(String id);
}
