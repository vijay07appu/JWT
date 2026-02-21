package com.jwt.JWT.service;

import com.jwt.JWT.Exception.DuplicateResourceException;
import com.jwt.JWT.dto.UserRequestDTO;
import com.jwt.JWT.dto.UserResponseDTO;
import com.jwt.JWT.entity.User;
import com.jwt.JWT.mapper.Mapper;
import com.jwt.JWT.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Mapper mapper;

    @Override
    public UserResponseDTO register(UserRequestDTO userRequestDTO){


        try{

            User userEntity=mapper.toEntity(userRequestDTO);
          User  savedUserEntity=userRepository.save(userEntity);
           return mapper.toResponseDTO(savedUserEntity);


        }catch(DataIntegrityViolationException ex){

            Throwable root= NestedExceptionUtils.getRootCause(ex);

            if(root instanceof ConstraintViolationException constraintEx){
                String constraintName=constraintEx.getConstraintName();

                if("uk_userName".equals(constraintName))
                {
                    throw new DuplicateResourceException("userName already Exists");
                }
                if("uk_email".equals(constraintName)){
                    throw new DuplicateResourceException("Email already Exists");
                }

            }

        }
        throw new DuplicateResourceException("Duplicate value found");

    }


}
