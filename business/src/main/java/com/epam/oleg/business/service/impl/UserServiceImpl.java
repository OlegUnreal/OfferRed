package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.entities.UserRole;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.UserCriteria;
import com.epam.oleg.business.repository.UserRepository;
import com.epam.oleg.business.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCriteria userCriteria;

    @Override
    public List<User> findAll(String email, String name, UserRole userRole, Gender gender, String city, Integer age) {
        return userCriteria.findAll(email, name, userRole, gender, city, age);
    }

    @Override
    public User getById(String id) {
        Optional<User> userDTO = userRepository.findById(id);
        return userDTO.orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email" + email + " not found"));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        throw new NotFoundException("Can't update user with id " + user.getId() + ". Product not found");
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
