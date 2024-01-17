package com.project.mailsystem.viewmodels.response;

public class UserDataResponse {
    private String firstname;
    private String lastname;
    private String company;
    private String department;
    private String mail;
    private String password;

    public UserDataResponse() {
    }

    public UserDataResponse(String firstname, String lastname, String company, String department, String mail, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.department = department;
        this.mail = mail;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
