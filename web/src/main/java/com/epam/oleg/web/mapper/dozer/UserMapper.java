package com.epam.oleg.web.mapper.dozer;

import com.epam.oleg.business.entities.User;
import com.epam.oleg.web.rest.vo.UserVO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

public class UserMapper {

    public static User toEntity(UserVO userVO) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(userVO, User.class);
    }
}
