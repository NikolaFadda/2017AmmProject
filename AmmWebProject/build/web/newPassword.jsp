<%-- 
    Document   : newPassword
    Created on : 24-set-2017, 15.48.07
    Author     : nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" type="text/css" rel="stylesheet"/>
        <title>Cambia Password></title>
        </head>
    <body>
        
        <div class="nav">
            <h1>Cambia password</h1><br><br>
            <a href="Logout">Logout</a>
            <a href="index.html">Pagina principale</a>
            <a href="Homepage">Torna al Profilo</a><br><br>
        </div>
        <div class="form">
        <form action="NewPassword">
            Vecchia Password:<br>
            <input type="password" name="oldPassword"><br><br>
            Nuova Password:<br>
            <input type="password" name="newPassword"><br><br>
            Ripeti la Nuova Password:<br>
            <input type="password" name="repNewPassword"><br><br>
            <input type="submit" value="Applica Modifiche">
        </form>
        </div>
        
    </body>
</html>
