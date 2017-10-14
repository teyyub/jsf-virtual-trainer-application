<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
  <f:loadBundle basename="com.jsfcompref.trainer.resources.UIResources"
                var="res"/>
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
      <title>
         <h:outputText value="#{res.title} - #{res['create.pageTitle']}"/>
      </title>
      <link href="../css/vt.css" rel="stylesheet" media="screen"></link>
      <link rel="shortcut icon" href="../images/favicon.ico">
    </head>
    <body><h:form>
        <table width="100%" border="0">
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
              <p><h:outputText value="#{res['create.header']}" styleClass="PageTitle"/></p>
              <h:messages globalOnly="true" infoClass="RegError"/>              

              <h:panelGrid width="70%" columns="3" border="0">

                <h:outputLabel value="#{res['create.eventName']}" for="ename" />
                <h:inputText  required="true"
                             id="ename" binding="#{CreateTe_Backing.ename}"
                             size="30"/>
                <h:message for="ename" errorClass="ValidateError"/>

                <h:outputLabel value="#{res['create.eventType']}" for="etype" />
                <h:selectOneMenu  binding="#{CreateTe_Backing.etype}" id="etype">
                  <f:selectItem itemLabel="#{res['create.type.fivek']}" itemValue="5k"/>
                  <f:selectItem itemLabel="#{res['create.type.tenk']}" itemValue="10k"/>
                  <f:selectItem itemLabel="#{res['create.type.halfMarathon']}"
                                itemValue="Half Marathon"/>
                  <f:selectItem itemLabel="#{res['create.type.fullMarathon']}"
                                itemValue="Full Marathon"/>
                  <f:selectItem itemLabel="#{res['create.type.triathlon']}" itemValue="Triathlon"/>
                  <f:selectItem itemLabel="#{res['create.type.workout']}" itemValue="Weekly Workout"/>
                </h:selectOneMenu>
                <f:verbatim>&nbsp;</f:verbatim>

                <h:outputLabel value="#{res['create.eventDate']}" for="doe"/>
                <h:inputText binding="#{CreateTe_Backing.doe}" id="doe"
                             required="true">
                  <f:convertDateTime pattern="MM-dd-yy"/>
                  <f:validator validatorId="futureDateValidate"/>
                </h:inputText>
                <h:message for="doe" errorClass="ValidateError"/>

                <h:outputLabel value="#{res['create.skill']}" for="skill"/>
                <h:selectOneMenu  binding="#{CreateTe_Backing.skill}" id="skill">
                  <f:selectItem itemLabel="#{res['create.skill.casual']}" itemValue="Casual"/>
                  <f:selectItem itemLabel="#{res['create.skill.basic']}"
                                itemValue="Basic Competitive"/>
                  <f:selectItem itemLabel="#{res['create.skill.medium']}"
                                itemValue="Medium Competitive"/>
                  <f:selectItem itemLabel="#{res['create.skill.advanced']}"
                                itemValue="Advanced Competitive - Olympic"/>
                </h:selectOneMenu>
                <f:verbatim>&nbsp;</f:verbatim>

                <h:outputLabel value="#{res['create.trainer']}" for="trainer"/>
                <h:selectOneMenu  binding="#{CreateTe_Backing.trainer}"
                                 id="trainer">
                  <f:selectItems value="#{CreateTe_Backing.trainerList}"/>
                </h:selectOneMenu>
                <f:verbatim>&nbsp;</f:verbatim>

                <f:verbatim>&nbsp;</f:verbatim>
                <h:commandButton value="#{res['create.createButton']}"
                                 action="#{CreateTe_Backing.CreateTEAction}"/>
                <h:commandButton value="#{res['create.cancelButton']}" action="main" immediate="true" />

              </h:panelGrid>

            </td>
          </tr>
        </table>
      </h:form></body>
  </html>
</f:view>