package com.project.mailsystem.viewmodels.response;

public class CreateUserResponse {
    private String mail;

    private String password;

    public CreateUserResponse(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public CreateUserResponse() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
