package com.project.mailsystem.services;

import com.project.mailsystem.models.UsersEntity;
import com.project.mailsystem.repositories.UserRepository;
import com.project.mailsystem.viewmodels.request.CreateUserRequest;
import com.project.mailsystem.viewmodels.response.CreateUserResponse;
import com.project.mailsystem.viewmodels.response.UserDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    final int defaultPasswordLength = 10;
    public CreateUserResponse createUser(CreateUserRequest request){
        CreateUserResponse response = new CreateUserResponse();
        UsersEntity user = new UsersEntity();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setCompany(request.getCompany());
        user.setDepartment(request.getDepartment());
        user.setSecondEmail(request.getEmail());
        user.setSmsNumber(request.getSmsNumber());
        user.setEmailCompany(this.createEmailCompany(user));
        String password = this.randomPassword(defaultPasswordLength);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userRepository.save(user);

        response.setMail(user.getEmailCompany());
        response.setPassword(password);
        return response;
    }

    public UserDataResponse getDataResponse(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity usersEntity = userRepository.findByEmailCompany((String) authentication.getPrincipal())
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + authentication.getPrincipal() + "no existe."));
        UserDataResponse response = new UserDataResponse();
        response.setFirstname(usersEntity.getFirstname());
        response.setLastname(usersEntity.getLastname());
        response.setDepartment(usersEntity.getDepartment());
        response.setCompany(usersEntity.getCompany());
        response.setPassword(usersEntity.getPassword());
        response.setMail(usersEntity.getEmailCompany());
        return response;
    }



    private String createEmailCompany(UsersEntity user){
        return user.getFirstname().toLowerCase() + "." +
                user.getLastname().toLowerCase() +
                "@" + user.getDepartment() + "." +
                user.getCompany() + ".com";
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKMNOPQRSTUVWXYZ0123456789!<@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

}
