package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.service.impl.UserServiceImpl;
import com.epam.oleg.web.mapper.dozer.UserMapper;
import com.epam.oleg.web.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserVO userVO) {
        User user = UserMapper.toEntity(userVO);
        return ResponseEntity.ok(userService.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserVO userVO) {
        User user = UserMapper.toEntity(userVO);
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }
}
