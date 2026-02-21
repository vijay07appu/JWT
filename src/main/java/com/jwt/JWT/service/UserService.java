package com.jwt.JWT.service;



import com.jwt.JWT.dto.UserRequestDTO;
import com.jwt.JWT.dto.UserResponseDTO;
import com.jwt.JWT.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   public UserResponseDTO register(UserRequestDTO userRequestDTO);
}
