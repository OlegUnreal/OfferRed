package com.epam.oleg.training_project.repository;

import com.epam.oleg.training_project.entities.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User getById(String id);
}
