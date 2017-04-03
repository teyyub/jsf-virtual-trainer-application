package com.project.bean;

import com.project.model.User;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * UserBean.java serves as the POJO for storing information about a Virtual
 * Trainer User.
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

    private User user = new User();

//  private String firstname;
//  private String lastname;
//  private String gender;
//  private Date dob;
//  private String email;
//  private String serviceLevel;
//  private String userid;
//  private String password;
    private boolean trainer;
    private boolean isLoggedIn;

    private int accountNo = -1;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserBean() {
        System.out.println("user "+user);        
    }

    public UserBean(int accountNo, String firstName, String lastName, String gender, Date dob, String email, String serviceLevel, String userid, String password, boolean isTrainer) {
 
    }

 
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void validateEmail(FacesContext context, UIComponent toValidate, Object value)
            throws ValidatorException {
        String eMail = (String) value;
        if (!eMail.contains("@")) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }

    public boolean isTrainer() {
        return trainer;
    }
 
}
