package com.project.bean;

import com.jsfcompref.trainer.util.JSFUtil;
import com.jsfcompref.trainer.util.UserUtil;
import com.project.model.User;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * Backing bean for register.jsp
 */
@ManagedBean(name = "registerBean")
@RequestScoped
public class Register {

    @ManagedProperty(value = "#{userRegistry}")
    private UserRegistryBean userRegistry;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private User user = new User();
 

    private final static String AUTH_USER = "Authorized_User";

    public Register() {
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserRegistryBean getUserRegistry() {
        return userRegistry;
    }

    public void setUserRegistry(UserRegistryBean userRegistry) {
        this.userRegistry = userRegistry;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void validateEmail(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String eMail = (String) value;
        if (!eMail.contains("@")) {
            FacesMessage message = new FacesMessage("Invalid email address!");
            throw new ValidatorException(message);
        }
    }

    public void validatePassword(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {

        // String password1 = (String)this.getPassword().getValue();
        String password2 = (String) value;

//    if(!password1.equals(password2)) {
//      FacesMessage message = new FacesMessage("Passwords do not match!");
//      throw new ValidatorException(message);
//    }
    }

    public String userRegister() {
        System.out.println("registerUser");
        return "register.xhtml?faces-redirect=true";
    }

    public String registerUser() {
 
        if (userRegistry.AddRegisteredUser(user) == null) {
            // userid exists

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Userid " + user.getUserId() + " already exists! Please choose another."));
 
            return (null);
        } else {

            // Is a new user, continue logging in
//            UserBean managedUserBean
//                    = (UserBean) JSFUtil.getManagedObject("UserBean");
//            UserUtil.copyUserProperties(newUser, managedUserBean);
            userBean.setIsLoggedIn(true);

            //Place AUTH_USER string on session to disable security filter on session to disable security filter
            JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Successful!"));
            System.out.println("Done Registering User..");
            return ("app/main.xhtml?faces-redirect=true");

        }

    }

 
}
