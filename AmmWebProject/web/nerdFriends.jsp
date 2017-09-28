<%-- 
    Document   : nerdFriends
    Created on : 25-set-2017, 14.56.18
    Author     : nikola
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" type="text/css" rel="stylesheet"/>
        <title>Cerca Nerd</title>
    </head>
    <body>
        <h1>Cerca altri Nerd</h1><br>
        <div id="links">
            <a href="Logout">Logout</a>
            
            <a href="Homepage">Torna al Profilo</a>
        </div>
        <p>Ecco la lista completa degli utenti:</p><br>
        
        
            <div>
                <c:forEach var="visitedUser" items="${visitedUtenti}">
                    <div class="item">
                    <b> ${visitedUser.nome} ${visitedUser.cognome}</b>
                    <form action="Homepage">
                    
                        <input type="hidden" name="visitedUser" value="${visitedUser.username}">
                        <input type="submit" value="Profilo">
                        
                    </form>
                    </div><br>    
                    
                </c:forEach>
            </div>
       
    </body>
</html>
