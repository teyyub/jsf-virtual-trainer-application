<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<f:verbatim>
    <table width="100%" class="BarBkgnd"><tr><td align="left">
                </f:verbatim>
        <h:outputLabel value="#{res['mainbar.welcome']} " styleClass="GUITag" />
        <h:outputText id="userid"  value="#{UserBean.userid}" />
        <f:verbatim>
        </td><td align="left">
</f:verbatim>
<h:outputLabel value="#{res['mainbar.membershipStatus']} " styleClass="GUITag"  />
<h:outputText id="level" value="#{UserBean.serviceLevel}" rendered="#{!UserBean.trainer}"/>
<h:outputLabel value="#{res['mainbar.trainer']}" styleClass="TrainerConsole" rendered="#{UserBean.trainer}"/>

<f:verbatim>
</td><td align="right">
</f:verbatim>
<h:commandLink action="main">
    <h:outputText value="#{res['mainbar.mainLink']}"/>
</h:commandLink>
<f:verbatim>&nbsp; | &nbsp;</f:verbatim>
<h:commandLink action="#{Login_Backing.logout}"  immediate="true">
    <h:outputText value="#{res['mainbar.logoutLink']}"/>
</h:commandLink>
<f:verbatim></td></tr></table>
</f:verbatim>