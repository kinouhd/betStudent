<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: antho
  Date: 15/02/2018
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creation match</title>
    <link rel="stylesheet" href="./css/w3.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lobster">
    <style>
        .w3-lobster {
            font-family: "Lobster", serif;
        }
        .w3-textMatch{
            font-family: "Times New Roman", Times, serif;
        }
    </style>
</head>

<body style="width: 100%; height: 100%; background-image: url('./img/pageConnexionCDM.jpg">




<div class="w3-container w3-display-middle w3-grey w3-round-xxlarge w3-lobster">
    <h1 class="w3-container w3-center w3-lobster">Formulaire creation de match</h1>


    <div class="w3-textMatch">
        <s:form action="creationMatch">
            <s:textfield name="equipeDOM" label="Equipe DOMICILE"/>
            <s:textfield name="equipeEXT" label="Equipe EXTERIEUR"/>
            <s:submit value="Créer match" cssClass=" w3-lobster"/>
        </s:form>
    </div>

    <div style="margin-left:45%; width:100%">

        <s:form action="retourAccueilAdmin">
            <s:submit value="Retour"/>
        </s:form>
    </div>
</div>
</body>
</html>
