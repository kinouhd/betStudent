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
<link rel="stylesheet" href="./css/w3.css">
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Lobster">
<head>
    <meta charset="UTF-8">
    <title>PAGE DE CONNEXION</title>
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
    <h1 class="w3-container w3-center w3-lobster">Page de connexion</h1>


    <div class="w3-textMatch">
        <s:form action="login">
        <s:textfield name="pseudo" key="index.pseudo"  size="16"/>
        <s:password name="password" key="index.password"  size="16"/>
        <s:submit value="Se Connecter" cssClass="w3-button w3-block w3-white w3-lobster"/>
    </s:form>
    </div>
</div>




</body>
</html>
