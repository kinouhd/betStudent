<%--
  Created by IntelliJ IDEA.
  User: antho
  Date: 14/02/2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" href="./css/w3.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lobster">
    <meta charset="UTF-8">
    <title>Accueil Administrateur</title>
    <style>
        .w3-lobster {
            font-family: "Lobster", serif;
        }
    </style>
</head>


<body style="width: 100%; height: 100%; background-image: url('./img/pageConnexionCDM.jpg">


<div class="w3-container w3-display-middle w3-grey w3-round-xxlarge w3-lobster">
    <h1 class="w3-container w3-center w3-lobster">Menu</h1>


    <div style="width:100%">
        <s:form action="goToCloturer">
            <s:submit value="Cloturer un pari" cssClass="w3-button"/>
        </s:form>
    </div>


    <div style=" width:100%">
        <s:form action="goToValiderMatch">
            <s:submit value="Valider un match" cssClass="w3-button"/>
        </s:form>
    </div>
    <div style=" width:100%">
        <s:form action="goToCreerMatch">
            <s:submit value="Creer un match" cssClass="w3-button"/>
        </s:form>
    </div>
    <div style="width:100%">
        <s:form action="goToCreationUser">
            <s:submit value="Creer un compte utilisateur" cssClass="w3-button"/>
        </s:form>
    </div>
    <div style="width:100%">
        <s:form action="deconnexion">
            <s:submit value="Se deconnecter" cssClass="w3-button"/>
        </s:form>
    </div>
</div>

</body>
</html>
