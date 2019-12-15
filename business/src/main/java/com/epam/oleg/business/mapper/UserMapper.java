package com.epam.oleg.business.mapper;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.repository.dto.UserDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

public class UserMapper {
    public static User toEntity(UserDTO userDTO) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(userDTO, User.class);
    }

    public static UserDTO toDto(User user) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(user, UserDTO.class);
    }
}
