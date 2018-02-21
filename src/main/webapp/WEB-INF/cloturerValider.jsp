<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: antho
  Date: 15/02/2018
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cloture valider</title>
    <link rel="stylesheet" href="./css/w3.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lobster">
    <style>
        .w3-lobster {
            font-family: "Lobster", serif;
        }
    </style>
</head>


<body style="width: 100%; height: 100%; background-image: url('./img/pageConnexionCDM.jpg">
<div class="w3-container w3-display-middle w3-grey w3-round-xxlarge w3-lobster">
    <h1 class="w3-container w3-center w3-lobster">La cloture du pari a correctement été prise en compte</h1>

    <div style="margin-left:43%; width:100%">
        <s:form action="retourAccueilAdmin">
            <s:submit value="Retour"/>
        </s:form>
    </div>
</div>



</body>
</html>
