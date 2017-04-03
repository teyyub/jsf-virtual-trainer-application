package com.project.model;

import java.util.Date;


/**
 * TrainingSession.java serves as the POJO that stores information about a single
 * workout session. A parent TrainingEvent contains a List of TrainingSessions 
 * (workoutsessions).
 */


public class TrainingSession
{
  private int id;
  private Date workoutDate;
  private String workoutDescription;
  private boolean completed = false;
  private String personalNotes;
  private String trainerNotes;

  public TrainingSession()
  {
  }
  
  public TrainingSession(int id, Date workoutdate, String workoutdesc, boolean completed, String personalnotes, String trainingnotes)
  {
  this.id=id;
  this.workoutDate=workoutdate;
  this.workoutDescription=workoutdesc;
  this.completed=completed;
  this.personalNotes=personalnotes;
  this.trainerNotes=trainingnotes;
  }
  
    

  public void setId(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }

  public void setWorkoutDate(Date workoutDate)
  {
    this.workoutDate = workoutDate;
  }

  public Date getWorkoutDate()
  {
    return workoutDate;
  }

  public void setWorkoutDescription(String workoutDescription)
  {
    this.workoutDescription = workoutDescription;
  }

  public String getWorkoutDescription()
  {
    return workoutDescription;
  }

  public void setCompleted(boolean completed)
  {
    this.completed = completed;
  }

  public boolean isCompleted()
  {
    return completed;
  }

  public void setPersonalNotes(String personalNotes)
  {
    this.personalNotes = personalNotes;
  }

  public String getPersonalNotes()
  {
    return personalNotes;
  }

  public void setTrainerNotes(String trainerNotes)
  {
    this.trainerNotes = trainerNotes;
  }

  public String getTrainerNotes()
  {
    return trainerNotes;
  }
}