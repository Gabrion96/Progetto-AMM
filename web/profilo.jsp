<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        
        <jsp:include page="sidebar.jsp" />
       
        <c:if test="${loggedIn == true}">
        <div id="divBodyProfilo">
            <div class="titolo">
                <h1>Profilo</h1>
            </div>
            
            <div class="profilePic">
                <img src="${utente.URLimmagine}">
            </div>
            
            <form action="Profilo?update=true" method="Post">
                <div class="campi">
                    <label for="name">Nome</label> 
                    <input type="text" name="name" 
                            id="nomeProfilo" value="${utente.nome}"/>

                
                    <label for="cognome">Cognome</label> 
                    <input type="text" name="cognome" 
                           id="cognome" value="${utente.cognome}"/>

              
                    <label for="url">Img Profilo</label>
                    <input type="url" name="url"
                           id="url" value="${utente.URLimmagine}"/>

               
                    <label for="frase">Frase di presentazione</label>
                    <input type="text" name="frase"
                           id="frase" value="${utente.frase}">
           

                    <label for="data">Data di Nascita</label>
                    <input type="date" name="data"
                           id="data" value="${utente.data}"/>
              
            
                    <label for="pswd">Password</label>
                    <input type="password" name="pswd"
                        id="pswd" value="" />

                    <label for="conpswd">Conferma Password</label>
                    <input type="password" name="conpswd"
                           id="conpswd" value="" />
                </div>   
                
                <div id="aggiorna">
                    <button type="submit">Aggiorna</button>
                </div>
                <c:if test="${update != null}">
                    <div>
                        Aggiornamento riuscito!
                    </div>
                </c:if>
            </form>
        </div>  
        </c:if>
        <c:if test="${loggedIn == null}">
            <div>
                Accesso Negato
            </div>
        </c:if>
    </body>   
</html>