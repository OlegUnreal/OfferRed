package com.epam.oleg.training_project.repository.impl;

import com.epam.oleg.training_project.entities.User;
import com.epam.oleg.training_project.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
