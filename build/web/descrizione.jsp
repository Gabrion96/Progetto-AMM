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
        <c:set var="active" value="Descrizione" scope="request" />
        <jsp:include page="header.jsp" />
        
        <div id="divBodyDescrizione">
            <div class="titolo">
                <h1>Sommario</h1>
            </div>
            <a href="#link1">A chi è rivolto ?</a>
            <br/>
            <a href="#link2">Come iscriversi ?</a>
            <br/>
            <a href="#link3">Gratis ?</a>
            <br/>
            <a href="#link4">Si paga ?</a>
            <br/>

            <a id="link1">
              <h3>A chi è rivolto ?</h3>  
            </a>
            <p>A tutti i nerd stanchi di nerdare da soli!!!</p>
            <a id="link2">
                <h3>Come iscriversi?</h3>
            </a>
            <p>Puoi controllare la guida di Salvatore Aranzulla :)</p>
            <a id="link3">
                <h3>Gratis ?</h3>
            </a>
            <p>Ovviamente è completamente GRATIS!!!</p>  
            <a id="link4">
                <h3>Si paga ?</h3>
            </a>
            <p>Solo se si vuole supportare lo sviluppo di NerdBook !(vi conviene)</p>
        </div>
    </body>
    
</html>