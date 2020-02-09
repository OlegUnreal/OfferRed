package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.entities.UserRole;
import com.epam.oleg.business.repository.UserCriteria;
import com.epam.oleg.business.service.impl.UserServiceImpl;
import com.epam.oleg.web.rest.dto.UserDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;
    private UserCriteria userCriteria;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(@PageableDefault Pageable pageable,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) UserRole userRole,
                             @RequestParam(required = false) Gender gender,
                             @RequestParam(required = false) String city,
                             @RequestParam(required = false) Integer age) {
        return userCriteria.findAll(email, name, userRole, gender, city, age);
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
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }
}
