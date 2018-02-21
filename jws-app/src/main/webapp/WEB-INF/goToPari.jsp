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
<title>Liste des paris</title>
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
    <h1 class="w3-container w3-center w3-lobster">Liste des paris disponibles</h1>


    <div>
        <table class="w3-table w3-textMatch">
        <s:iterator value="listeMatch">
            <tr>
                <td style="text-align: center;">
                    <s:url action="parier" var="monUrl">
                        <s:param name="idMatch" value="idMatch"/>
                    </s:url>
                    <s:property value="equipeDOM"/>
                </td>
                <td style="text-align: center"> - </td>
                <td style="text-align: center"><s:property value="equipeEXT" /></td>
                <td style="text-align: center"><s:a href="%{#monUrl}" cssClass=" w3-round-xxlarge w3-lobster">Parier</s:a></td>
            </tr>
        </s:iterator>
        </table>
    </div>

    <div style="margin-left:38%; width:100%">
        <s:form action="retourAccueil">
            <s:submit value="Retour"/>
        </s:form>
    </div>
</div>

</body>

</html>
