<%-- 
    Document   : login
    Created on : Nov 12, 2023, 10:51:27 AM
    Author     : djamel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="./css/inlogin.css">
    </head>
    <body>
        <div class="login-box">
        <h2>Login</h2>
    <form action="Home" method="post">
        <div class="textbox">   <input type="text" name="username" placeholder="Username" required></div>
        <div class="textbox">   <input type="password" name="password" placeholder="Password" required></div>
        
        <p style="color: #d63031">${error}</p>
         
<input class="btn" type="submit" value="Login" ${disableLogin ? 'disabled' : ''}>
    </form>
     
        </div>
        <!-- Display the message inside the <p> tag -->
    </body>
</html>
