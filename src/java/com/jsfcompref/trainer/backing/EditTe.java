package com.jsfcompref.trainer.backing;
import com.project.model.TrainingEvent;
import com.project.TrainingEventRegistryBean;
import com.jsfcompref.trainer.util.JSFUtil;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

@ManagedBean(name="EditTe_Backing")
public class EditTe 
{
  public EditTe()
  {
  }
  
  private UIData data = null;
  
    public String saveTEAction()
     {
       FacesContext ctx = FacesContext.getCurrentInstance();
       Application app = ctx.getApplication();
       
       //Grab edited TrainingEvent and store locally as "te"
       TrainingEvent te = (TrainingEvent)JSFUtil.getManagedObject("EditTrainingEvent");
             
       // Grab TrainingEventRegistry  - store in "eventRegistry"
       TrainingEventRegistryBean eventRegistry = (TrainingEventRegistryBean) JSFUtil.getManagedObject("TrainingEventRegistry");
       
       // Call TE registry method to update registry with edited training event.
//       eventRegistry.updateTrainingEvent(te);
       return null;
     }

// Scroller methods below
     
  /**
   * Handles the ActionEvent generated as a result of clicking on a
   * link that points a particular page in the result-set.
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
 
  /**
   * <p>Scroll to the page that contains the specified row number.</p>
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


  public void setData(UIData data) {
    this.data = data;
  }

  public UIData getData() {
    return data;
  }
}
