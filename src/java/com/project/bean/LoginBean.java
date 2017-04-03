package com.project.bean;

import com.jsfcompref.trainer.util.UserUtil;
import com.jsfcompref.trainer.util.JSFUtil;
import com.project.model.User;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Backing bean for login.jsp
 */
@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean implements Serializable {

//    private HtmlInputText userid;
//    private HtmlInputSecret password;
    private User currentUser;
    private User user = new User();

    private final static String AUTH_USER = "Authorized_User";

//    @ManagedProperty(value = "#{userBean}")
//    private UserBean userBean;
    @ManagedProperty(value = "#{userRegistry}")
    private UserRegistryBean userRegistry;

    public LoginBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

//    public UserBean getUserBean() {
//        return userBean;
//    }
//
//    public void setUserBean(UserBean userBean) {
//        this.userBean = userBean;
//    }
    public UserRegistryBean getUserRegistry() {
        return userRegistry;
    }

    public void setUserRegistry(UserRegistryBean userRegistry) {
        this.userRegistry = userRegistry;
    }

    public String login() {
        //Grab UserRegistry Managed Bean
        System.out.println("login started");
//        UserRegistry userRegCopy= (UserRegistry) JSFUtil.getManagedObject("UserRegistry");
        System.out.println("user = " + user);
        // Call findByUserCredentials method 
        // and retrieve currentUser which matches credentials
        currentUser
                = userRegistry.findUserByCredentials(user.getUserId(), user.getUserPassword());

        if (currentUser == null) {
            // login failed
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Invalid Login!"));
            return null;
        } else {
            // login success
//      UserBean managedUserBean = (UserBean)JSFUtil.getManagedObject("UserBean");
//      UserUtil.copyUserProperties(currentUser, managedUserBean);
//      managedUserBean.setIsLoggedIn(true);

//            UserUtil.copyUserProperties(currentUser, userBean);
//            userBean.setIsLoggedIn(true);
            // Place authorized user on session to disable security filter
            JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");
            return "/app/main.xhtml?faces-redirect=true";
        }
    }

    public String logout() throws IOException {
        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.invalidate();

//        FacesContext ctx = FacesContext.getCurrentInstance();
//        Application app = ctx.getApplication();
//        app.getNavigationHandler().handleNavigation(ctx, "index.xhtml", "index");
        // To avoid using the navigation handler you could also use...
        //response.sendRedirect("../index.jsp");
        return "/index.xhtml?faces-redirect=true";

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
//            userBean.setIsLoggedIn(true);
            //Place AUTH_USER string on session to disable security filter on session to disable security filter
            JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Successful!"));
            System.out.println("Done Registering User..");
            return ("app/main.xhtml?faces-redirect=true");

        }

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

        String password1 = (String) this.getUser().getUserPassword();
        String password2 = (String) value;

        if (!password1.equals(password2)) {
            FacesMessage message = new FacesMessage("Passwords do not match!");
            throw new ValidatorException(message);
        }
    }
}
