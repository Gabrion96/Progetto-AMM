<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Nerdbook: Trova nuovi amici nerd come te!!</title>

        <meta charset="utf-8">
        <meta name="viewport"
            content="width=device-width,
            initial-scale=1.0">
        <meta name="author"
            content="Gabriele">
        <meta name="Keywords"
            content="cerca amici nerd ">    
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        
    </head>
    
    <body>
        <c:set var="active" value="Login" scope="request" />
        <jsp:include page="header.jsp" />
  
        <div id="divBodyLogin">
            <div class="titolo">
                <h1>Login</h1>
            </div>
            <c:if test="${invalidData == true}">
                <div> Username o Password errati </div>
            </c:if>
            <form action="Login" method="post">
                <div class="username">
                    <label for="username">Username</label>
                    <input type="text" name="username"
                           id="username" value="" />
                    <br>
                </div>
                <div class="password">
                    <label for="pswd">Password</label>
                    <input type="password" name="password"
                       id="password" value="" />
                </div>
                <div id="invio">
                    <button type="submit">Accedi</button>
                </div>
            </form>
        </div>
           
    </body>
       
</html>
