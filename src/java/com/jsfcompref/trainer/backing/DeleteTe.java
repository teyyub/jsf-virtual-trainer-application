package com.jsfcompref.trainer.backing;

import com.project.model.TrainingEvent;
import com.project.TrainingEventRegistryBean;
import com.jsfcompref.trainer.util.JSFUtil;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 * Backing bean for delete_te.jsp
 */


public class DeleteTe {
  public DeleteTe() {
  }


  public String deleteTEAction() {
    FacesContext ctx = FacesContext.getCurrentInstance();
    Application app = ctx.getApplication();

    //Get TrainingEvent to be delete and store locally as "te"
    TrainingEvent te = (TrainingEvent)JSFUtil.getManagedObject("EditTrainingEvent");

    // Get TrainingEventRegistry  - store in "eventRegistry"
   TrainingEventRegistryBean eventRegistry = (TrainingEventRegistryBean) JSFUtil.getManagedObject("TrainingEventRegistry");

    // Call TE registry method to delete the selected training event.
//    eventRegistry.deleteTrainingEvent(te);
    return "main";
  }


}
