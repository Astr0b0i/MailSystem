package com.project.mailsystem.utils;

import com.project.mailsystem.models.UsersEntity;
import com.project.mailsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByEmailCompany(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + "no existe."));

        User user = new User(usersEntity.getEmailCompany(), usersEntity.getPassword(),true,true,true,true,new ArrayList<>());

        return user;
    }
}
