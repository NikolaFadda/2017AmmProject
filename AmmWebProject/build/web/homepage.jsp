<%-- 
    Document   : homepage
    Created on : 23-set-2017, 11.58.54
    Author     : nikola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" type="text/css" rel="stylesheet"/>
        <title>${user.nome} - Homepage</title>
    </head>
    <body>
        <c:set var="page" value="bacheca" scope="request"/>
        
        <br>
        <br>
        <div id="links">
            <a href="Logout">Logout</a>
            
            <a href="SearchFriends">Cerca Nerd</a>
            <a href="newPassword.jsp">Modifica Password</a>
        </div>
        <br>
        <div>
            <h1>${user.nome} ${user.cognome}</h1>
            <p>
                <i>
                    "${user.quote}"
                </i>
            </p>
        </div>
        <br>
        <c:if test="${trueFriends == true}">
        <div class="post">
            <h3>Nuovo post:</h3>
            <fieldset>
            <form class="post" action="NewPost">
                
                
                <textarea cols="40" rows="5" name="message"></textarea><br><br>
                Allegato:
                <input type="text" name="attachment"><br><br>
                <input type="submit" value="Pubblica">
                
            </form>
            </fieldset>
        </div>
        </c:if>
        <br><br>
        
        <c:if test ="${trueFriends == false}">
            
            <div>
                <form action="NewFriends">
                    <input type="hidden" name ="user2" value="${user.username}">
                    <input type="submit" value="Stringi amicizia con ${user.nome}!">
                </form>
            </div>
                <br>
        </c:if>
        <div id="wrapper">
        <div class="item">
        <c:forEach var="post" items="${posts}">
            
            
                <p>${post.messaggio}</p><br>
                <b>Autore:</b> <i>${post.autore.nome} ${post.autore.cognome}</i><br>
                <b>Allegato:</b> ${post.allegato}
                </div>
            
            
        <br>    
        <div class="item">
        
        </c:forEach>
        </div>
        </div>
        
    </body>
</html>
