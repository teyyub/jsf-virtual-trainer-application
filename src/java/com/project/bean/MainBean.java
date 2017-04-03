package com.project.bean;

import com.project.model.TrainingEvent;
import com.project.TrainingEventRegistryBean;
import com.jsfcompref.trainer.util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Backing bean for main.jsp
 */
@ManagedBean(name = "Main_Backing")
@RequestScoped
public class MainBean implements Serializable{

    @ManagedProperty(value="#{userBean}")
    private UserBean userBean;
    
    @ManagedProperty(value="#{trainingEventRegistryBean}")
    private TrainingEventRegistryBean trainingEventRegistryBean;
    
    private static final int SORT_BY_EVENT = 0;
    private static final int SORT_BY_DATE = 1;
    private static final int SORT_BY_SKILL = 2;
    private static final int SORT_BY_STATUS = 3;
    private static final int SORT_BY_USERID = 4;

    private int sortBy = -1;

    private boolean sortEventAsc = false;
    private boolean sortDateAsc = false;
    private boolean sortSkillAsc = false;
    private boolean sortStatusAsc = false;
    private boolean sortUserIdAsc = false;

    private boolean showSortEventIcon = false;
    private boolean showSortDateIcon = false;
    private boolean showSortSkillIcon = false;
    private boolean showSortStatusIcon = false;
    private boolean showSortUserIdIcon = false;

    private TrainingEvent event = new TrainingEvent();
    
    
    public MainBean() {
    }

    public TrainingEventRegistryBean getTrainingEventRegistryBean() {
        return trainingEventRegistryBean;
    }

    public void setTrainingEventRegistryBean(TrainingEventRegistryBean trainingEventRegistryBean) {
        this.trainingEventRegistryBean = trainingEventRegistryBean;
    }

     

    public TrainingEvent getEvent() {
        return event;
    }

    public void setEvent(TrainingEvent event) {
        this.event = event;
    }

  
   

    private UIData data = null;

    /**
     * <p>
     * Scroll to the page that contains the specified row number.</p>
     *
     * @param row Desired row number
     */
    public void scroll(int row) {

        int rows = data.getRows();
        if (rows < 1) {
            return; // Showing entire table already
        }
        if (row < 0) {
            data.setFirst(0);
        } else if (row >= data.getRowCount()) {
            data.setFirst(data.getRowCount() - 1);
        } else {
            data.setFirst(row - (row % rows));
        }

    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

   
    
    /**
     * Handles the ActionEvent generated as a result of clicking on a link that
     * points a particular page in the result-set.
     */
    public void processScrollEvent(ActionEvent event) {
        int currentRow = 1;

        //     FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = event.getComponent();
        Integer curRow = (Integer) component.getAttributes().get("currentRow");
        if (curRow != null) {
            currentRow = curRow.intValue();
        }
        // scroll to the appropriate page in the ResultSet.
        scroll(currentRow);
    }

    public List getTrainingEventsForUser() {
        // Get training events for this user, or all if user is a trainer

        // get user id from MB facility
        // get UserBean - grab userid
        System.out.println("getTrainingEventsForUser started");
        List userEventList = new ArrayList();
//        UserBean managedUserBean= (UserBean) JSFUtil.getManagedObject("UserBean");

//        String userid = userBean.getUserid();

//        TrainingEventRegistry eventRegistry = (TrainingEventRegistry) JSFUtil.getManagedObject("TrainingEventRegistry");

        // If user is a trainer, return all Training Events, else only return events for user.
//        if (userBean.isTrainer()) {
//            userEventList = getTrainingEventRegistryBean().getAllEvents();
//        } else {
            // is not a trainer so call getEventlistForUser
//            userEventList = getTrainingEventRegistryBean().getEventlistForUser(userid);
//        }

        // Sort event list
//        sortEvents(userEventList);

        return userEventList;
    }

    public String editTrainingEventAction() {

        
        System.out.println("selected event="+event.getEname());
        
//        TrainingEvent selectedTrainingEvent = (TrainingEvent) this.getData().getRowData();
//        FacesContext ctx = FacesContext.getCurrentInstance();

        //Store selected TrainingEvent Row accessible later as #{EditTrainingEvent} 
//        ctx.getExternalContext().getSessionMap().put("EditTrainingEvent", selectedTrainingEvent);

        // go to edit page..
        return "edit.xhtml?faces-redirect=true";
    }

    //Sort events
    private void sortEvents(List TrainingEvents) {

        switch (sortBy) {
            case SORT_BY_EVENT:
                Collections.sort(TrainingEvents, sortEventAsc ? SortTrainingEventAscComparator : SortTrainingEventDescComparator);
                break;

            case SORT_BY_DATE:
                Collections.sort(TrainingEvents, sortDateAsc ? SortDateAscComparator : SortDateDescComparator);
                break;

            case SORT_BY_SKILL:
                Collections.sort(TrainingEvents, sortSkillAsc ? SortSkillAscComparator : SortSkillDescComparator);
                break;

            case SORT_BY_STATUS:
                Collections.sort(TrainingEvents, sortStatusAsc ? SortStatusAscComparator : SortStatusDescComparator);
                break;

            case SORT_BY_USERID:
                Collections.sort(TrainingEvents, sortUserIdAsc ? SortUserIdAscComparator : SortUserIdDescComparator);
                break;

            default:
                break;
        }

    }

// Sort ActionListener Methods
    // Each toggles their respective boolean sort flags 
    // and sets sortBy value
    public void sortByEvent(ActionEvent ae) {
        sortEventAsc = !sortEventAsc;
        sortBy = SORT_BY_EVENT;
    }

    public void sortByDate(ActionEvent ae) {
        sortDateAsc = !sortDateAsc;
        sortBy = SORT_BY_DATE;
    }

    public void sortBySkill(ActionEvent ae) {
        sortSkillAsc = !sortSkillAsc;
        sortBy = SORT_BY_SKILL;
    }

    public void sortByStatus(ActionEvent ae) {
        sortStatusAsc = !sortStatusAsc;
        sortBy = SORT_BY_STATUS;
    }

    public void sortByUserId(ActionEvent ae) {
        sortUserIdAsc = !sortUserIdAsc;
        sortBy = SORT_BY_USERID;
    }

// Sort Comparators
    private static final Comparator SortTrainingEventAscComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getEname();
            String s2 = ((TrainingEvent) o2).getEname();
            return s1.compareTo(s2);
        }
    };

    private static final Comparator SortTrainingEventDescComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getEname();
            String s2 = ((TrainingEvent) o2).getEname();
            return s2.compareTo(s1);
        }
    };

    private static final Comparator SortDateDescComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            Date d1 = ((TrainingEvent) o1).getCompletionDate();
            Date d2 = ((TrainingEvent) o2).getCompletionDate();
            return d2.compareTo(d1);
        }
    };

    private static final Comparator SortDateAscComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            Date d1 = ((TrainingEvent) o1).getCompletionDate();
            Date d2 = ((TrainingEvent) o2).getCompletionDate();
            return d1.compareTo(d2);
        }
    };

    private static final Comparator SortSkillAscComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getSkill();
            String s2 = ((TrainingEvent) o2).getSkill();
            return s1.compareTo(s2);
        }
    };

    private static final Comparator SortSkillDescComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getSkill();
            String s2 = ((TrainingEvent) o2).getSkill();
            return s2.compareTo(s1);
        }
    };

    private static final Comparator SortStatusAscComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getStatus();
            String s2 = ((TrainingEvent) o2).getStatus();
            return s1.compareTo(s2);
        }
    };

    private static final Comparator SortStatusDescComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getStatus();
            String s2 = ((TrainingEvent) o2).getStatus();
            return s2.compareTo(s1);
        }
    };

    private static final Comparator SortUserIdAscComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getUserid();
            String s2 = ((TrainingEvent) o2).getUserid();
            return s1.compareTo(s2);
        }
    };

    private static final Comparator SortUserIdDescComparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            String s1 = ((TrainingEvent) o1).getUserid();
            String s2 = ((TrainingEvent) o2).getUserid();
            return s2.compareTo(s1);
        }
    };

// Property getters - setters
    public void setData(UIData data) {
        this.data = data;
    }

    public UIData getData() {
        return data;
    }

    public void setSortEventAsc(boolean sortEventAsc) {
        this.sortEventAsc = sortEventAsc;
    }

    public boolean isSortEventAsc() {
        return sortEventAsc;
    }

    public void setSortDateAsc(boolean sortDateAsc) {
        this.sortDateAsc = sortDateAsc;
    }

    public boolean isSortDateAsc() {
        return sortDateAsc;
    }

    public void setSortSkillAsc(boolean sortSkillAsc) {
        this.sortSkillAsc = sortSkillAsc;
    }

    public boolean isSortSkillAsc() {
        return sortSkillAsc;
    }

    public void setSortStatusAsc(boolean sortStatusAsc) {
        this.sortStatusAsc = sortStatusAsc;
    }

    public boolean isSortStatusAsc() {
        return sortStatusAsc;
    }

    public void setSortUserIdAsc(boolean sortUserIdAsc) {
        this.sortUserIdAsc = sortUserIdAsc;
    }

    public boolean isSortUserIdAsc() {
        return sortUserIdAsc;
    }

    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }

    public int getSortBy() {
        return sortBy;
    }

    public boolean isShowSortEventIcon() {
        showSortEventIcon = (sortBy == SORT_BY_EVENT);
        return (showSortEventIcon);
    }

    public boolean isShowSortDateIcon() {
        showSortDateIcon = (sortBy == SORT_BY_DATE);
        return showSortDateIcon;
    }

    public boolean isShowSortSkillIcon() {
        showSortSkillIcon = (sortBy == SORT_BY_SKILL);
        return showSortSkillIcon;
    }

    public boolean isShowSortStatusIcon() {
        showSortStatusIcon = (sortBy == SORT_BY_STATUS);
        return showSortStatusIcon;
    }

    public boolean isShowSortUserIdIcon() {
        showSortUserIdIcon = (sortBy == SORT_BY_USERID);
        return showSortUserIdIcon;
    }

}
