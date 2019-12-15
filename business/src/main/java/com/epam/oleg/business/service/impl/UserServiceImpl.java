package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.mapper.UserMapper;
import com.epam.oleg.business.repository.UserRepository;
import com.epam.oleg.business.repository.dto.UserDTO;
import com.epam.oleg.business.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public User getById(String id) {
        Optional<UserDTO> userDTO = userRepository.findById(id);
        return userDTO.map(UserMapper::toEntity).orElse(null);
    }

    @Override
    public User create(User user) {
        UserDTO userDTO = userRepository.save(UserMapper.toDto(user));
        return UserMapper.toEntity(userDTO);
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getId())) {
            return UserMapper.toEntity(userRepository.save(UserMapper.toDto(user)));
        }
        //Exception should be thrown
        return null;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
