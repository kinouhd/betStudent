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
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lobster">
    <title>Classement</title>
    <style>
        .w3-lobster {
            font-family: "Lobster", serif;
        }
    </style>
</head>





<body style="width: 100%; height: 100%; background-image: url('./img/pageConnexionCDM.jpg">


<div class="w3-container w3-display-middle w3-grey w3-round-xxlarge w3-lobster" >
    <h1 class="w3-container w3-center w3-lobster">Classement</h1>


    <div >
        <table class="w3-table">
            <tr><td style="text-align:center">Position</td><td>  |  </td><td style="text-align:center">Pseudo</td><td>  |  </td><td style="text-align:center">Points</td></tr>
        <s:iterator value="listeJoueurs">
            <tr>
                <td style="text-align:center"><s:property value="position"/></td>
                <td>  |  </td>
                <td style="text-align:center"><s:property value="nom" /></td>
                <td>  |  </td>
                <td style="text-align:center"><s:property value="pointsClassement"/></td>
            </tr>
        </s:iterator>
        </table>
    </div>


    <div style="margin-left:43%; width:100%">
        <s:form action="retourAccueil">
            <s:submit value="Retour"/>
        </s:form>
    </div>
</div>

</body>







</body>
</html>
