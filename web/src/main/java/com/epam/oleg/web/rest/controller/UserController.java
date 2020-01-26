package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.service.impl.UserServiceImpl;
import com.epam.oleg.web.rest.vo.UserDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<User> getAll(@PageableDefault Pageable pageable) {
        return userService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody @Valid UserDTO userDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        User user = DozerBeanMapperBuilder.buildDefault()
                .map(userDTO, User.class);
        return userService.create(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody @Valid UserDTO userDTO) {
        User user = DozerBeanMapperBuilder.buildDefault()
                .map(userDTO, User.class);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }
}
