package com.project.mailsystem;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;

    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String alternateEmail;
    private String email;

    private String companySuffix = "aeycompay.com";

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        //System.out.println("Email created: " + this.firstname + " " + this.lastname);
        this.department = this.setDepartment();
        //System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("Your default password is: " + this.password);
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);

    }

    public String setDepartment() {
        this.department = department;
        System.out.println("Department codes\n1 for sales\n2 for development\n3 for accounting\n0 for none\nEnter department code: ");
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


}
