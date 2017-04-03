package com.jsfcompref.trainer.backing;

import com.project.TrainingEventRegistryBean;
import com.project.model.TrainingEvent;
 
import com.project.bean.UserBean;
import com.project.bean.UserRegistryBean;
import com.jsfcompref.trainer.util.JSFUtil;
import com.project.model.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

/**
 * Backing bean for create_te.jsp
 */
@ManagedBean(name = "createBean")
public class CreateTe {

    @ManagedProperty(value = "#{userRegistry}")
    private UserRegistryBean userRegistryBean;
    
    @ManagedProperty(value="#{trainingEventRegistryBean}")
    private TrainingEventRegistryBean  trainingEventRegistryBean;
    
    private String ename;
    private String etype;
    private Date doe;
    private String skill;
    private String trainer;
    private List<User> trainers = new ArrayList();

    public CreateTe() {
    }

    public String CreateTEAction() {

        // Create new Training Event
        TrainingEvent newTe = new TrainingEvent();
        newTe.setEname(ename);
        newTe.setEtype(etype);
        newTe.setCompletionDate(doe);
        newTe.setSkill(skill);
        newTe.setTrainer(trainer);
        newTe.setStatus("Not Started");
//   
//   //Generate a set of training sessions sessions based on the event date and type 
   Calendar calendar = new GregorianCalendar();
   calendar.setTime(doe);
//   
//   TrainingEventRegistry eventRegistry = (TrainingEventRegistry) JSFUtil.getManagedObject("TrainingEventRegistry");
//   
   List workoutList = trainingEventRegistryBean.generateTrainingSessionList(calendar, newTe.getEtype());
//    
   newTe.setWorkoutsessions(workoutList);
//   
//   // Get userid info from managed bean
//   UserBean currentUser = (UserBean) JSFUtil.getManagedObject("UserBean");      
//   // and assign to the new training event
//   newTe.setUserid(currentUser.getUserid());   
//   
//
//   // Add new training event to registry
//   eventRegistry.addTrainingEvent(newTe);
        return "/app/main.xhtml";
    }

    public UserRegistryBean getUserRegistryBean() {
        return userRegistryBean;
    }

    public void setUserRegistryBean(UserRegistryBean userRegistryBean) {
        this.userRegistryBean = userRegistryBean;
    }

    public TrainingEventRegistryBean getTrainingEventRegistryBean() {
        return trainingEventRegistryBean;
    }

    public void setTrainingEventRegistryBean(TrainingEventRegistryBean trainingEventRegistryBean) {
        this.trainingEventRegistryBean = trainingEventRegistryBean;
    }

    public List getTrainerList() {

//  UserRegistry userRegistry = (UserRegistry) JSFUtil.getManagedObject("UserRegistry");
        List trainers = userRegistryBean.findTrainerUsers();
        List selectTrainers = new ArrayList();
        selectTrainers = trainers;
//  for (int i = 0; i < trainers.size(); i++) {
//    UserBean user = (UserBean) trainers.get(i);
////    selectTrainers.add(new SelectItem(user.getFirstname(), user.getFirstname()));
//  }
        return selectTrainers;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public List<User> getTrainers() {

        trainers = userRegistryBean.findTrainerUsers();
//        List selectTrainers = new ArrayList();
//        selectTrainers  = trainers;
//  for (int i = 0; i < trainers.size(); i++) {
//    UserBean user = (UserBean) trainers.get(i);
////    selectTrainers.add(new SelectItem(user.getFirstname(), user.getFirstname()));
//  }
//        return selectTrainers;
        return trainers;
    }

    public void setTrainers(List<User> trainers) {
        this.trainers = trainers;
    }

}
