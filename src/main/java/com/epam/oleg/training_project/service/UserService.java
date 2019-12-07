package com.epam.oleg.training_project.service;

import com.epam.oleg.training_project.entities.User;
import com.epam.oleg.training_project.rest.vo.UserVO;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(String id);

    User create(UserVO userVO);

    User update(UserVO userVO);

    void delete(String id);
}
