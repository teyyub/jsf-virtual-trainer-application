<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://virtualsportstrainer.com/trainercomponents" prefix="t"%>

<f:view>
  <f:loadBundle basename="com.jsfcompref.trainer.resources.UIResources"
                var="res"/>
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
      <title>
        <h:outputText value="#{res.title} - #{res['edit.pageTitle']}"/>
      </title>
      <link href="../css/vt.css" rel="stylesheet" media="screen"></link>
      <link rel="shortcut icon" href="../images/favicon.ico">
    </head>
    <body><h:form>
        <table width="100%" border="0" >
          <tr>
            <td>
              <h1 align="center">
                <h:graphicImage url="/images/vtlogo.jpg"
                                alt="Virtual Trainer Logo"/>
                <h:outputText value="#{res.title}"/>
              </h1>
            </td>
          </tr>
          <tr>
            <td>
              <f:subview id="mainbar">
                <jsp:include page="mainbar.jsp"/>
              </f:subview>
            </td>
          </tr>
          <tr>
            <td>
            <p>&nbsp;</p>
       <p>
       <h:outputText value="#{res[edit.header]}" styleClass="PageTitle"/>
       </p>

        <h:messages/>
              <h:panelGrid  columns="4" styleClass="form-bkg"
                           rowClasses="list-row" width="80%">
                
                <h:outputLabel value="#{res[edit.eventTitle]}" styleClass="GUITag" for="ename"/>
                <h:outputText id="ename" value="#{EditTrainingEvent.ename}"/>
                
                <h:outputLabel value="#{res[edit.eventType]}" styleClass="GUITag" for="etype" />
                <h:outputText id="etype" value="#{EditTrainingEvent.etype}"/>                
                
                <h:outputLabel value="#{res[edit.eventDate]}" styleClass="GUITag" for="date" />
                <h:outputText id="date" value="#{EditTrainingEvent.completionDate}">
                  <f:convertDateTime pattern="MM-dd-yy"/>
                </h:outputText>
                
                <h:outputLabel value="#{res[edit.skill]}" styleClass="GUITag" for="skill" />
                <h:outputText id="skill" value="#{EditTrainingEvent.skill}"/>
                
                <h:outputLabel value="#{res[edit.currentStatus]}" styleClass="GUITag" for="status"/>                
                <h:selectOneMenu id="status" value="#{EditTrainingEvent.status}">
                  <f:selectItem itemLabel="#{res['edit.status.notStarted']}"
                                itemValue="Not Started"/>
                  <f:selectItem itemLabel="#{res['edit.status.inProgress']}"
                                itemValue="In Progress"/>
                  <f:selectItem itemLabel="#{res['edit.status.completed']}" itemValue="Completed"/>
                  <f:selectItem itemLabel="#{res['edit.status.ongoing']}" itemValue="Ongoing"/>
                </h:selectOneMenu>
                
                
                <h:outputLabel value="#{res[edit.trainer]}" 
                               styleClass="GUITag" for="trainer"/>
                <h:outputText id="trainer" value="#{EditTrainingEvent.trainer}"/>
              </h:panelGrid>
              <h:panelGrid columns="3" width="25%" cellpadding="12"
                           styleClass="form-bkg">
                <h:commandButton value="#{res[edit.updateButton]}"
                                 action="#{EditTe_Backing.saveTEAction}"/>
                <h:commandButton value="#{res[edit.deleteButton]}"
                                 action="delete"/>
                <h:commandButton value="#{res[edit.returnButton]}"
                                 action="main"/>
              </h:panelGrid>                   
                          
                            
  <h:outputText value="#{res[edit.sessionHeader]}" styleClass="PageTitle"/>             
  
<h:dataTable id="sessionsTable"  value="#{EditTrainingEvent.workoutsessions}"
   binding="#{EditTe_Backing.data}" var="se"  rows="5"
   rowClasses="list-row-odd,list-row-even" headerClass="table-header" 
   width="100%" >
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="#{res[edit.workout]} #"/>
                    </f:facet>
                    <h:outputText value="#{se.id}"/>
                  </h:column>
                  <h:column>
                  
                    <f:facet name="header">
                      <h:outputText value="#{res[edit.workoutDate]}"/>
                    </f:facet>
                    <h:outputText value="#{se.workoutDate}">
                    <f:convertDateTime pattern="MM-dd-yy"/>
                  </h:outputText>
                  </h:column>
                  
                       <h:column>
                    <f:facet name="header">
                      <h:outputText value="#{res[edit.assignedWorkout]}"/>
                    </f:facet>
                    <h:outputText value="#{se.workoutDescription}"/>
                  </h:column>
                  
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="#{res[edit.completed]}"/>
                    </f:facet>
                    <h:selectBooleanCheckbox value="#{se.completed}" />
                  </h:column>
                  
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="#{res[edit.personalNotes]}"/>
                    </f:facet>
                    <h:inputText  value="#{se.personalNotes}" disabled="#{se.completed}"/>                    
                  </h:column>
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="#{res[edit.trainerNotes]}"/>
                    </f:facet>
                    <!-- UserBean.trainer will be set to => ((HttpServletRequest)request).isUserInRole(“trainer”); at login time. -->
                    <h:inputText  rendered="#{UserBean.trainer}" value="#{se.trainerNotes}"/>
                    <h:outputText rendered="#{!UserBean.trainer}" value="#{se.trainerNotes}"/>
                  </h:column>
  </h:dataTable>
      <!-- Custom Scroller Component -->
                
      <t:scroller navFacetOrientation="NORTH" for="sessionsTable" actionListener="#{EditTe_Backing.processScrollEvent}">

      <f:facet name="next">
        <h:panelGroup>
          <h:outputText value="Next"/>
          <h:graphicImage url="/images/arrow-right.gif" />
        </h:panelGroup>
      </f:facet>

      <f:facet name="previous">
        <h:panelGroup>
          <h:outputText value="Previous"/>
          <h:graphicImage url="/images/arrow-left.gif" />
        </h:panelGroup>
      </f:facet>

    </t:scroller>


            </td>
          </tr>
        </table>
      </h:form></body>
  </html>
</f:view>