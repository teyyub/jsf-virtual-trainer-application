package com.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * TrainingEvent is the POJO that is used to store information about a single
 * future athletic event. It contains a List of workoutsessions which users 
 * will use to train for the event.
 */

 
public class TrainingEvent implements Serializable
{
  private int id;  
  private String userid;
  private String ename;
  private Date completionDate;
  private String skill;
  private String status;
  private String etype;
  private String trainer;
  private List workoutsessions;

  public TrainingEvent()
  {
  }

  public TrainingEvent(TrainingEvent src)
  {
    this.id=src.getId();
    this.ename=src.getEname();
    this.etype=src.getEtype();
    this.completionDate=src.getCompletionDate();
    this.skill=src.getSkill();
    this.status=src.getStatus();
    this.trainer=src.getTrainer();
    this.workoutsessions=src.getWorkoutsessions();
    this.userid=src.getUserid();
  }


  public TrainingEvent(int id, String ename, String etype, Date completionDate, String skill, String status, String trainer, List workoutsessions, String userid)
  {  
    this.id=id;
    this.ename=ename;
    this.etype=etype;
    this.completionDate=completionDate;
    this.skill=skill;
    this.status=status;
    this.trainer=trainer;
    this.workoutsessions=workoutsessions;
    this.userid=userid;
  }


  public String getEname()
  {
    return ename;
  }

  public void setEname(String ename)
  {
    this.ename = ename;
  }

  public Date getCompletionDate()
  {
    return completionDate;
  }

  public void setCompletionDate(Date completionDate)
  {
    this.completionDate = completionDate;
  }

  public String getSkill()
  {
    return skill;
  }

  public void setSkill(String skill)
  {
    this.skill = skill;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getEtype()
  {
    return etype;
  }

  public void setEtype(String etype)
  {
    this.etype = etype;
  }

  public void setTrainer(String trainer)
  {
    this.trainer = trainer;
  }

  public String getTrainer()
  {
    return trainer;
  }

 
  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUserid() {
    return userid;
  }

    public void setWorkoutsessions(List workoutsessions) {
        this.workoutsessions = workoutsessions;
    }

    public List getWorkoutsessions() {
        return workoutsessions;
    }
  @Override
    public String toString(){
     return "[id\t" +id
             + "  userid " + userid
             + " ename "+ ename
             + " completionDate " +completionDate
             + " skill " +skill
             + " status " +status
             + " etype " +etype
             +" trainer " +trainer
             + "]";
    }
}
