package com.jwt.JWT.service;

import com.jwt.JWT.entity.User;
import com.jwt.JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
    {
        try{
            User userDB=userRepository.findUserByUserName(userName);
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(userDB.getUserName())
                    .password(userDB.getPassword())
                    .build();

        }catch(Exception e){
            throw new UsernameNotFoundException("Username not found, Try different one");
        }

    }
}
