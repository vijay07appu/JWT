package com.jwt.JWT.mapper;

import com.jwt.JWT.dto.UserDTO;
import com.jwt.JWT.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private UserDTO toDTO (User user)
    {
        if(user==null)
        {
            return null;
        }
       return UserDTO.builder()
                .userName(user.getUserName())
               .email(user.getEmail())
               .build();
    }

    private User toEntity(UserDTO userDTO){
        if(userDTO==null)
        {
            return null;
        }
        return User.builder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .build();
    }
}
