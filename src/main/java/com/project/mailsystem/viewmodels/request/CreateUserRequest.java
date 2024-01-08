package com.project.mailsystem.viewmodels.request;

public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String company;
    private String department;
    private String email;
    private String smsNumber;

    public CreateUserRequest(String firstname, String lastname, String company, String department, String email, String smsNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.department = department;
        this.email = email;
        this.smsNumber = smsNumber;
    }

    public CreateUserRequest() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }
}
