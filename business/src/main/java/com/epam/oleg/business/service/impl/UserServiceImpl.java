package com.epam.oleg.training_project.service.impl;

import com.epam.oleg.training_project.entities.User;
import com.epam.oleg.training_project.repository.UserRepository;
import com.epam.oleg.training_project.rest.vo.UserVO;
import com.epam.oleg.training_project.service.UserService;
import com.epam.oleg.training_project.utils.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getById(String id) {
        return userRepository.getById(id);
    }

    @Override
    public User create(UserVO userVO) {
        User user = userMapper.toEntity(userVO);
        return userRepository.create(user);
    }

    @Override
    public User update(UserVO userVO) {
        User user = userMapper.toEntity(userVO);
        return userRepository.update(user);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }
}
