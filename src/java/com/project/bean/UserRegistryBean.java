package com.project.bean;

import com.project.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * UserRegistry.java serves as the POJO that manages a List of registered users
 * for the Virtual Trainer application.
 *
 * This Java demo version is not persisted and creates a set of demo users upon
 * instantiation.
 *
 * Like TrainingEventRegistry.java it is also registered as an application
 * scoped managed bean.
 */
@ManagedBean(name = "userRegistry")
@ApplicationScoped
public class UserRegistryBean implements Serializable {

    private List<User> RegisteredUsers = new ArrayList();

//    @PostConstruct
//    void init() {
//
//    }

    public UserRegistryBean() {

        RegisteredUsers.add(new User(1, "Guest", "Guest", "male", new java.util.Date(), "guest@vtrainer.com", "Basic", "guest", "guest", false));
        RegisteredUsers.add(new User(2, "Scott", "Tiger", "male", new java.util.Date(), "stiger@vtrainer.com", "Medium", "stiger", "welcome", false));
        RegisteredUsers.add(new User(3, "Claire", "Dassault", "female", new java.util.Date(), "claire@vtrainer.com", "Medium", "claire", "claire", false));
        RegisteredUsers.add(new User(4, "Joe", "Fitness", "male", new java.util.Date(), "jfitness@vtrainer.com", "Premium", "jfitness", "jfitness", true));
        RegisteredUsers.add(new User(5, "Jake", "DeJoque", "male", new java.util.Date(), "guest@vtrainer.com", "Premium", "jake", "jake", true));
        RegisteredUsers.add(new User(6, "Sally", "Sweats", "female", new java.util.Date(), "guest@vtrainer.com", "Premium", "sally", "sally", true));

    }

    public List<User> getRegisteredUsers() {
        return RegisteredUsers;
    }

    public void setRegisteredUsers(List<User> RegisteredUsers) {
        this.RegisteredUsers = RegisteredUsers;
    }

    public String AddRegisteredUser(User newUser) {
        // Calculate new account id based on size of user registry
        // For demo only - Persistent technology will use a sequence
        int usercnt = RegisteredUsers.size();
        newUser.setAccountNo(usercnt + 1);

        // First check to see if userid already exists
        if (!userIdAlreadyExists(newUser.getUserId())) {

            RegisteredUsers.add(newUser);
            return newUser.getUserId();
        }

        // Return userid of registered user
        return null;
    }

    public String AddRegisteredUser(UserBean newUser) {
        // Calculate new account id based on size of user registry
        // For demo only - Persistent technology will use a sequence
        int usercnt = RegisteredUsers.size();
        newUser.setAccountNo(usercnt + 1);

        // First check to see if userid already exists
//        if (!userIdAlreadyExists(newUser.getUserid())) {
//
//            RegisteredUsers.add((UserBean) newUser);
//            return newUser.getUserid();
//        }
        // Return userid of registered user
        return null;
    }

    public User findUserByCredentials(String userid, String password) {
        boolean found = false;
        User currentUser;

        // temporarily turn ArrayList into static array of UserBeans 
        // then just return the first UserBean.
        User userArray[] = new User[RegisteredUsers.size()];
        userArray = (User[]) RegisteredUsers.toArray(userArray);

        int i = 0;

        while (!found && i < RegisteredUsers.size()) {
            currentUser = userArray[i];

            if (currentUser.getUserId().equals(userid) && currentUser.getUserPassword().equals(password)) {
                // Found user!
                found = true;
                return userArray[i];
            }
            i++;
        }

        return null;
    }

    public boolean userIdAlreadyExists(String userid) {
        boolean found = false;
        User currentUser;

        // Temporarily turn ArrayList into static array of UserBeans 
        // then just return the first UserBean.
//        UserBean userArray[] = new UserBean[RegisteredUsers.size()];
//        userArray = (UserBean[]) RegisteredUsers.toArray(userArray);

        int i = 0;

        while (!found && i < RegisteredUsers.size()) {
            currentUser = RegisteredUsers.get(i);

            if (currentUser.getUserId().equals(userid)) {
                // Found user!
                found = true;
                return found;
            }
            i++;
        }
        return found;
    }

    public List findTrainerUsers() {  // Returns only list of Users with trainer status
        ArrayList trainerlist = new ArrayList();

        for (int i = 0; i < this.RegisteredUsers.size(); i++) {
            User user = (User) RegisteredUsers.get(i);
            if (user.isTrainer()) {
                trainerlist.add(user);
            }
        }
        return trainerlist;
    }

}
