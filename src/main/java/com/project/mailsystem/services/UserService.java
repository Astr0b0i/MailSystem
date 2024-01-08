package com.project.mailsystem.services;

import com.project.mailsystem.models.UsersEntity;
import com.project.mailsystem.repositories.UserRepository;
import com.project.mailsystem.viewmodels.request.CreateUserRequest;
import com.project.mailsystem.viewmodels.response.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
        response.setMail(this.createEmailCompany(user));
        response.setPassword(this.randomPassword(defaultPasswordLength));
        user.setEmailCompany(response.getMail());
        user.setPassword(response.getPassword());
        userRepository.save(user);
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
