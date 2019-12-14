package com.epam.oleg.web.mapper;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.web.rest.vo.UserVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User toEntity(UserVO userVO);

    UserVO toUserVO(User user);
}
