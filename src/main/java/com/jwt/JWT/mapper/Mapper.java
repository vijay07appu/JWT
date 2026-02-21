package com.jwt.JWT.mapper;


import com.jwt.JWT.dto.UserRequestDTO;
import com.jwt.JWT.dto.UserResponseDTO;
import com.jwt.JWT.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserResponseDTO toResponseDTO (User user)
    {
        if(user==null)
        {
            return null;
        }
       return UserResponseDTO.builder()
               .id(user.getId())
                .userName(user.getUserName())
               .email(user.getEmail())
               .build();
    }

    public User toEntity(UserRequestDTO userRequestDTO){
        if(userRequestDTO==null)
        {
            return null;
        }
        return User.builder()
                .userName(userRequestDTO.getUserName())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .build();
    }
}
