package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.service.impl.UserServiceImpl;
import com.epam.oleg.web.mapper.dozer.UserMapper;
import com.epam.oleg.web.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<User> getAll(@RequestParam(required = false) @PageableDefault Pageable pageable) {
        return userService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody UserVO userVO) {
        User user = UserMapper.toEntity(userVO);
        return userService.create(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody UserVO userVO) {
        User user = UserMapper.toEntity(userVO);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }
}
