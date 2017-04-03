package com.project;

import com.project.model.TrainingSession;
import com.project.model.TrainingEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

/**
 * TrainingEventRegistry serves as the interface to the Web UI. It has methods
 * for accessing/querying/updating/deleting a List of TrainingEvents. The
 * non-persisted Java demo version, creates demo data upon instantiation. This
 * class is registered as an application scoped managed bean.
 */
@ManagedBean(name = "trainingEventRegistryBean")
@ApplicationScoped
public class TrainingEventRegistryBean implements Serializable {

    private TrainingEvent event = new TrainingEvent();
    private List eventlist = new ArrayList();

    final static int eventDateInc = 21;
    final static int workoutDateInc = 2;
    private String page_row = "5";
    private List<TrainingSession> workoutsessions = new ArrayList();
    public TrainingEventRegistryBean() {
        // Populate TrainingEventRegistry with sample data for some registered users.

        // Create realistic dates based on today's date for demo purposes
        Calendar calendar = new GregorianCalendar();
        Date today = new java.util.Date();
        calendar.setTime(today);

//        eventlist = new ArrayList();
        // Register events for stiger
        // populate with future event data
        calendar.add(Calendar.DATE, 100);

        eventlist.add(new TrainingEvent(1, "South Valley 10k", "10k", calendar.getTime(), "Casual", "Completed", "Jake", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(2, "San Francisco 1/2 Marathon", "Half Marathon", calendar.getTime(), "Casual", "In Progress", "Chris", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(3, "Pleasanton Tri for Fun Triathlon", "Triathlon", calendar.getTime(), "Basic Competitive", "In Progress", "Ed", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(4, "San Diego Full Marathon", "Marathon", calendar.getTime(), "Medium Competitive", "In Progress", "Wendy", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(5, "Bakersfield Triathlon", "Triathlon", calendar.getTime(), "Medium Competitive", "In Progress", "James", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(6, "Phoenix Extreme Challenge", "Triathlon", calendar.getTime(), "Medium Competitive", "In Progress", "Herb", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(7, "Portland Trailblazer Half Marathon", "Half Marathon", calendar.getTime(), "Basic Competitive", "In Progress", "Ed", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(8, "Seattle 10k", "10k", calendar.getTime(), "Medium Competitive", "In Progress", "Claire", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(9, "Reno 1/2 Marathon", "Half Marathon", calendar.getTime(), "Medium Competitive", "In Progress", "Owen", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(10, "Las Vegas Marathon", "Marathon", calendar.getTime(), "Medium Competitive", "In Progress", "Ed", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(11, "Ongoing Weekly Training", "Weekly Workout", calendar.getTime(), "Basic Competitive", "In Progress", "Chris", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(12, "Marin County 10k", "10k", calendar.getTime(), "Casual", "Completed", "Jake", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(13, "Los Angeles 1/2 Marathon", "Half Marathon", calendar.getTime(), "Casual", "Completed", "Chris", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(14, "Seattle Coffee Run", "Half Marathon", calendar.getTime(), "Basic Competitive", "In Progress", "Ed", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(15, "Houston Marathon", "Marathon", calendar.getTime(), "Medium Competitive", "Completed", "Wendy", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(16, "Kansas City Triathlon", "Triathlon", calendar.getTime(), "Medium Competitive", "Ongoing", "James", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(17, "Chicago Challenge", "Triathlon", calendar.getTime(), "Medium Competitive", "Ongoing", "Herb", generateTrainingSessionList(calendar, "demo"), "guest"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(18, "Dallas Half Marathon", "Half Marathon", calendar.getTime(), "Basic Competitive", "In Progress", "Ed", generateTrainingSessionList(calendar, "demo"), "guest"));

        // Register events for stiger
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 100);
        eventlist.add(new TrainingEvent(19, "Atlanta 5k", "5k", calendar.getTime(), "Medium Competitive", "Ongoing", "Claire", generateTrainingSessionList(calendar, "demo"), "stiger"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(20, "Reno 1/2 Marathon", "Half Marathon", calendar.getTime(), "Medium Competitive", "Ongoing", "Owen", generateTrainingSessionList(calendar, "demo"), "stiger"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(21, "Las Vegas Marathon", "Marathon", calendar.getTime(), "Medium Competitive", "Ongoing", "Ed", generateTrainingSessionList(calendar, "demo"), "stiger"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(22, "Ongoing Weekly Training", "Weekly Workout", calendar.getTime(), "Basic Competitive", "Ongoing", "Chris", generateTrainingSessionList(calendar, "demo"), "stiger"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(23, "South Valley 10k", "10k", calendar.getTime(), "Casual", "Completed", "Jake", generateTrainingSessionList(calendar, "demo"), "stiger"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(24, "San Francisco 1/2 Marathon", "Half Marathon", calendar.getTime(), "Casual", "Not Started", "Chris", generateTrainingSessionList(calendar, "demo"), "stiger"));

        // Register events for claire
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 100);
        eventlist.add(new TrainingEvent(25, "Pleasanton Tri for Fun Triathlon", "Triathlon", calendar.getTime(), "Basic Competitive", "Not Started", "Ed", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(26, "San Diego Full Marathon", "Marathon", calendar.getTime(), "Medium Competitive", "Completed", "Wendy", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(27, "Bakersfield Triathlon", "Triathlon", calendar.getTime(), "Medium Competitive", "Ongoing", "James", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(28, "Phoenix Extreme Challenge", "Triathlon", calendar.getTime(), "Medium Competitive", "Not Started", "Herb", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(29, "Portland Trailblazer Half Marathon", "Half Marathon", calendar.getTime(), "Basic Competitive", "In Progress", "Ed", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(30, "Seattle 10k", "10k", calendar.getTime(), "Medium Competitive", "Ongoing", "Claire", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(31, "Reno 1/2 Marathon", "Half Marathon", calendar.getTime(), "Medium Competitive", "Ongoing", "Owen", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(32, "Las Vegas Marathon", "Marathon", calendar.getTime(), "Medium Competitive", "Not Started", "Ed", generateTrainingSessionList(calendar, "demo"), "claire"));
        calendar.add(Calendar.DATE, eventDateInc);
        eventlist.add(new TrainingEvent(33, "Ongoing Weekly Training", "Weekly Workout", calendar.getTime(), "Basic Competitive", "Not Started", "Chris", generateTrainingSessionList(calendar, "demo"), "claire"));
    }

    public List generateTrainingSessionList(Calendar calendar, String eventType) {
//        List sessionList = new ArrayList();
        if (eventType.equals("demo")) {
            // For demo purposes, populate sessionList with some initial default values
            // Move date back 16 days before event
            calendar.add(Calendar.DATE, -16);
            workoutsessions.add(new TrainingSession(1, calendar.getTime(), "Easy walk 1 mile", true, "That was easy!", "Good job!"));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(2, calendar.getTime(), "Light jog 1 mile", true, "A little sore now.", "It gets easier!"));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(3, calendar.getTime(), "Light jog 2 miles", true, "Very Easy", "Great Job!"));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(4, calendar.getTime(), "Easy run 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(5, calendar.getTime(), "Easy run 3 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(6, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(7, calendar.getTime(), "Fast run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(8, calendar.getTime(), "Easy run 3 miles", false, "", ""));
        } else if (eventType.equals("5k")) {
            // Move date back 20 days before event
            calendar.add(Calendar.DATE, -20);
            workoutsessions.add(new TrainingSession(1, calendar.getTime(), "Easy walk 1 mile", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(2, calendar.getTime(), "Light jog 1 mile", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(3, calendar.getTime(), "Light jog 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(4, calendar.getTime(), "Easy run 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(5, calendar.getTime(), "Easy run 3 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(6, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(7, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(8, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(9, calendar.getTime(), "Easy run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(10, calendar.getTime(), "Easy run 3 miles", false, "", ""));
        } else if (eventType.equals("10k")) {
            // Move date back 30 days before event
            calendar.add(Calendar.DATE, -30);
            workoutsessions.add(new TrainingSession(1, calendar.getTime(), "Easy walk 1 mile", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(2, calendar.getTime(), "Light jog 1 mile", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(3, calendar.getTime(), "Light jog 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(4, calendar.getTime(), "Easy run 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(5, calendar.getTime(), "Easy run 3 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(6, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(7, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(8, calendar.getTime(), "Moderate run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(9, calendar.getTime(), "Moderate run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(10, calendar.getTime(), "Fast run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(11, calendar.getTime(), "Fast run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(12, calendar.getTime(), "Moderate run 6 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(13, calendar.getTime(), "Fast run 6 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(14, calendar.getTime(), "Easy run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(15, calendar.getTime(), "Easy run 3 miles", false, "", ""));
        } else {
            // Handle all other event types in generic fashion, just have 15 generic workouts.
            calendar.add(Calendar.DATE, -30);
            workoutsessions.add(new TrainingSession(1, calendar.getTime(), "Easy walk 1 mile", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(2, calendar.getTime(), "Light jog 1 mile", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(3, calendar.getTime(), "Light jog 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(4, calendar.getTime(), "Easy run 2 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(5, calendar.getTime(), "Easy run 3 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(6, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(7, calendar.getTime(), "Moderate run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(8, calendar.getTime(), "Moderate run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(9, calendar.getTime(), "Moderate run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(10, calendar.getTime(), "Fast run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(11, calendar.getTime(), "Fast run 5 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(12, calendar.getTime(), "Moderate run 6 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(13, calendar.getTime(), "Fast run 6 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(14, calendar.getTime(), "Easy run 4 miles", false, "", ""));
            calendar.add(Calendar.DATE, workoutDateInc);
            workoutsessions.add(new TrainingSession(15, calendar.getTime(), "Easy run 3 miles", false, "", ""));
        }

        // This is where you could implement any other type of workout based on the event type
        // as well as other factors including user's skill level and age.
        // This exercise is left to the reader.
        return workoutsessions;
    }

    public List getWorkoutsessions() {
        return workoutsessions;
    }

    public String addTrainingEvent(TrainingEvent newTE) {
        // Calculate new id when adding
        // Persistence technologies would use a sequence

        int maxid = 0;

        // determine maximum id
        for (int i = 0; i < eventlist.size(); i++) {
            TrainingEvent trainingEvent = (TrainingEvent) eventlist.get(i);
            int currid = trainingEvent.getId();
            maxid = (currid > maxid) ? currid : maxid;
        }

        newTE.setId(maxid + 1);

        this.eventlist.add((TrainingEvent) newTE);
        return "success";
    }

    public String deleteTrainingEvent(/*TrainingEvent deletedTe*/) {
        System.out.println("deleting event: " + event.getEname());
        eventlist.remove(event);
        return "main?faces-redirect=true";
    }

    public String updateTrainingEvent(/*TrainingEvent updatedTe*/) {
        System.out.println("call updateTrainingEvent\t" + event.toString());
//        int targetEvent = updatedTe.getId();
//        String EventName = updatedTe.getEname();
//
//        System.out.println("update event id : " + targetEvent);
//        System.out.println("update event name : " + EventName);
//
//        if (targetEvent == 0) {
//            addTrainingEvent(updatedTe);
//        } else {
//            for (int i = 0; i < eventlist.size(); i++) {
//                TrainingEvent te = (TrainingEvent) eventlist.get(i);
//                if (te.getId() == updatedTe.getId()) {
//                    eventlist.set(i, updatedTe);
//                    return;
//                }
//            }
//        }

        for (int i = 0; i < eventlist.size(); i++) {
            TrainingEvent te = (TrainingEvent) eventlist.get(i);
            if (te.getId() == event.getId()) {
                eventlist.set(i, event);
            }
        }
        return "main?faces-redirect=true";
    }

    public List getEventlistForUser(String userId) {
        ArrayList userlist = new ArrayList();

        for (int i = 0; i < eventlist.size(); i++) {
            TrainingEvent trainingEvent = (TrainingEvent) eventlist.get(i);
            if (trainingEvent.getUserid().equals(userId)) {
                userlist.add(trainingEvent);
            }
        }

        return userlist;
    }

    public List getAllEvents() {
        // same as getEventList()
//        System.out.println("eventlist.size=" + eventlist.size());
        return eventlist;
    }

    public TrainingEvent getEvent() {
        return event;
    }

    public void setEvent(TrainingEvent event) {
        this.event = event;
    }

    public List getEventlist() {
        return eventlist;
    }

    public void setEventlist(List eventlist) {
        this.eventlist = eventlist;
    }

    public String getPage_row() {
        System.out.println("page_row\t" + page_row);
        return page_row;
    }

    public void setPage_row(String page_row) {
        this.page_row = page_row;
    }

    public void changeTableRow(ValueChangeEvent event) {
        System.out.println("changeTableRow called\t" + event);
    }
}
