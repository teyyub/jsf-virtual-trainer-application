package com.project.model;

import java.util.Date;

/**
 *
 * @author teyyub 12:19:57 PM
 */
public class User {

    private String userId;
    private String userPassword;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private String email;
    private String serviceLevel;
    private int accountNo;
    boolean trainer;

    public User() {

    }

    public User(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public User(int accountNo, String firstName, String lastName, String gender, Date dob, String email, String serviceLevel, String userid, String password, boolean isTrainer) {
        this.accountNo = accountNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.serviceLevel = serviceLevel;
        this.userId = userid;
        this.userPassword = password;
        this.trainer = isTrainer;

    }

    public String getUserId() {    
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {

        return "["
                + "userId " + userId
                + " userPassword " + userPassword
                + " firstName " + firstName
                + " lastName " + lastName
                + " gender " + gender
                + " dob " + dob
                + " email " + email
                + " serviceLevel " + serviceLevel
                + " accountNo " + accountNo
                + " trainer " + trainer
                + "]";
    }

}
