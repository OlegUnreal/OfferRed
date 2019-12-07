package com.epam.oleg.training_project.utils.mapper;

import com.epam.oleg.training_project.entities.User;
import com.epam.oleg.training_project.rest.vo.UserVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User toEntity(UserVO userVO);

    UserVO toUserVO(User user);
}
