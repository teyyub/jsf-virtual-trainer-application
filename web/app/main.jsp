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
                <h:outputText value="#{res.title} - #{res['main.pageTitle']}"/>
            </title>
            <link href="../css/vt.css" rel="stylesheet" media="screen"></link>
            <link rel="shortcut icon" href="../images/favicon.ico">
        </head>
        <body><h:form>
            <table width="100%" border="0" >
                <tr>
                    <td>
                        <h1 align="center">
                            <h:graphicImage url="/images/vtlogo.jpg" alt="Virtual Trainer Logo"/>
                            <h:outputText value="#{res.title}"/>
                        </h1>
                    </td>
                </tr>
                <tr>
                    <td>
                <h:messages infoClass="LoginSuccess" />
                <f:subview id="mainbar">
                    <jsp:include page="mainbar.jsp"/>
                </f:subview>
                </td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                    <td>
                <h:outputText value="#{res[main.header]}" styleClass="PageTitle"/>
                <h:dataTable id="eventsTable" rows="5"
                             value="#{Main_Backing.trainingEventsForUser}"
                             var="te" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{Main_Backing.data}">

                    <h:column rendered="#{userBean.trainer}">
                        <f:facet name="header">
                            <h:panelGroup>
                                <h:commandLink actionListener="#{Main_Backing.sortByUserId}"
                                               immediate="true">
                                    <h:outputText value="#{res[main.userAccount]}"/>
                                </h:commandLink>
                                <h:graphicImage url="#{Main_Backing.sortUserIdAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                                width="9" rendered="#{Main_Backing.showSortUserIdIcon}"/>                                      
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{te.userid}"/>
                    </h:column>


                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup>
                                <h:commandLink actionListener="#{Main_Backing.sortByEvent}"
                                               immediate="true">
                                    <h:outputText value="#{res[main.eventName]}"/>
                                </h:commandLink>
                                <h:graphicImage url="#{Main_Backing.sortEventAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                                width="9" rendered="#{Main_Backing.showSortEventIcon}"/>
                            </h:panelGroup>
                        </f:facet>                 
                        <h:outputText value="#{te.ename}"/>                    
                    </h:column>                

                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup>
                                <h:commandLink actionListener="#{Main_Backing.sortByDate}" immediate="true" >
                                    <h:outputText value="#{res[main.completionDate]}"/>
                                </h:commandLink>
                                <h:graphicImage url="#{!Main_Backing.sortDateAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                                width="9" rendered="#{Main_Backing.showSortDateIcon}"/>

                            </h:panelGroup>
                        </f:facet>                    
                        <h:outputText value="#{te.completionDate}">
                            <f:convertDateTime pattern="MM-dd-yy"/>
                        </h:outputText>
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup>
                                <h:commandLink actionListener="#{Main_Backing.sortBySkill}" immediate="true" >
                                    <h:outputText value="#{res[main.skillLevel]}"/>
                                </h:commandLink>                        
                                <h:graphicImage url="#{Main_Backing.sortSkillAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                                width="9" rendered="#{Main_Backing.showSortSkillIcon}"/>                                      
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{te.skill}"/>
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup>
                                <h:commandLink actionListener="#{Main_Backing.sortByStatus}" immediate="true" >                    
                                    <h:outputText value="#{res[main.status]}"/>
                                </h:commandLink>
                                <h:graphicImage url="#{Main_Backing.sortStatusAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                                width="9" rendered="#{Main_Backing.showSortStatusIcon}"/>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{te.status}"/>
                    </h:column>

                    <h:column>
                        <h:commandLink action="#{Main_Backing.editTrainingEventAction}">
                            <h:outputText value="#{res[main.select]}" />
                        </h:commandLink>
                    </h:column>
                </h:dataTable>

                <!-- Custom Scroller Component -->

                <t:scroller navFacetOrientation="NORTH" for="eventsTable" actionListener="#{Main_Backing.processScrollEvent}">

                    <f:facet name="next">
                        <h:panelGroup>
                            <h:outputText value="Next"/>
                            <h:graphicImage url="/images/arrow-right.gif" />
                        </h:panelGroup>
                    </f:facet>

                    <f:facet name="previous">
                        <h:panelGroup>
                            <h:graphicImage url="/images/arrow-left.gif" />
                            <h:outputText value="Previous"/>
                        </h:panelGroup>
                    </f:facet>

                </t:scroller>

                <h:commandButton value="#{res[main.createButton]}"
                                 action="create"/>
                </td>
                </tr>
            </table>
        </h:form></body>
    </html>
</f:view>