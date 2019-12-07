package com.epam.oleg.training_project.rest.controller;

import com.epam.oleg.training_project.entities.User;
import com.epam.oleg.training_project.rest.vo.UserVO;
import com.epam.oleg.training_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

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
        return ResponseEntity.ok(userService.create(userVO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserVO userVO) {
        return ResponseEntity.ok(userService.update(userVO));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }
}
