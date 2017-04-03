<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<f:view>
  <f:loadBundle basename="com.jsfcompref.trainer.resources.UIResources"
                var="res"/>
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
      <title> 
         <h:outputText value="#{res.title} - #{res['delete.pageTitle']}"/>
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
       <h:outputText value="#{res[\'delete.header\']}" styleClass="PageTitle"/>
       </p>

        <h:messages/>

              <h:panelGrid  columns="2" styleClass="form-bkg"
                           rowClasses="list-row" width="80%">
                
                <h:outputLabel value="#{res[\'delete.eventTitle\']}" styleClass="GUITag" for="ename"/>
                <h:outputText id="ename" value="#{EditTrainingEvent.ename}"/>
                
                <h:outputLabel value="#{res[\'delete.eventType\']}" styleClass="GUITag" for="etype"/>
                <h:outputText id="etype" value="#{EditTrainingEvent.etype}"/>                
                
                <h:outputLabel value="#{res[\'delete.eventDate\']}" styleClass="GUITag" for="date"/>
                <h:outputText id="date" value="#{EditTrainingEvent.completionDate}">
                  <f:convertDateTime pattern="MM-dd-yy"/>
                </h:outputText>
              </h:panelGrid>

                
              <h:panelGrid columns="2" width="35%" cellpadding="12">
                <h:commandButton value="#{res[\'delete.deleteButton\']}"
                                 action="#{DeleteTe_Backing.deleteTEAction}"/>
                <h:commandButton value="#{res[\'delete.cancelButton\']}"
                                 action="main" immediate="true"/>
              </h:panelGrid>                   
                      

            </td>
          </tr>
        </table>
      </h:form></body>
  </html>
</f:view>