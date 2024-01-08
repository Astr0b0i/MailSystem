package com.project.mailsystem.models;

import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String company;
    private String department;
    private String emailCompany;
    private String secondEmail;
    private String smsNumber;

    final static int defaultPasswordLength = 10;

    final static String companySuffix = "aeycompay.com";

    public UsersEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = this.setDepartmentFunction();
        this.password = randomPassword(defaultPasswordLength);
        emailCompany = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
    }

    public UsersEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmailCompany() {
        return emailCompany;
    }

    public void setEmailCompany(String emailCompany) {
        this.emailCompany = emailCompany;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public void setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }

    public String setDepartmentFunction() {
        System.out.println("Department codes:\n1 for sales\n2 for development\n3 for accounting\n0 for none\nEnter department code: ");
        Scanner ln = new Scanner(System.in);
        int depChoice = ln.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
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

    public String changePassword(String password) {
        this.password = password;
        return password;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display name: " + firstname + " " + lastname + "\n" +
                "Company email: " + emailCompany + "\n" +
                "Password: " + this.getPassword();
    }

}
