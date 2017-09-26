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
        <c:set var="active" value="Bacheca" scope="request" />
        <jsp:include page="header.jsp" />

        <jsp:include page="sidebar.jsp" />
        
        <c:if test="${loggedIn!=null}"> 
                
        <c:if test="${confirm == true}">
            <c:if test="${bachecapersonale.id != utente.id}">
                <div class="post white_border">
                    Hai scritto sulla bacheca di ${bachecapersonale.nome} ${bachecapersonale.cognome}
                </div>
            </c:if>
            <c:if test="${bachecapersonale.id == utente.id}">
                <div class="post white_border">
                    Hai scritto sulla tua bacheca
                </div>
            </c:if>
        </c:if>

        <div id="posts">
            <div class="post">
                <form action="Bacheca?revision=1&bachecaid=${bachecaPersonale.id}" method="post">
                    <div class="new">
                        <label for="text" class="write1">
                            Testo
                        </label>
                        <input type="text" name="text" value="" id="text" class="cell">
                    </div>
                    <div class="new">
                        <label for="img" class="write2">
                            Immagine
                        </label>
                        <input type="text" name="img" value="" id="img" class="cell">
                    </div>
                    <button>
                        Post
                    </button>
                </form>
            </div>
            <c:forEach var="post" items="${posts}">    
                <div class="post">
                    <div class="profile">
                        <div class="profilePic">
                            <img src="${bachecaPersonale.URLimmagine}">
                        </div>
                        <div class="profileName">
                            <h2>${bachecaPersonale.nome}</h2>
                        </div>
                    </div>
                    <div class="profileContent">
                        <c:if test="${post.text != ''}">
                            <p>${post.text}</p>
                        </c:if>
                        <c:if test="${post.image != ''}">
                            <img src="${post.image}">
                        </c:if>
                    </div>
                </div>
            </c:forEach>    
            <c:if test="${revision == true}">        
                <div class="post">
                    <form action="Bacheca?confirm=1&bachecaid=${bachecapersonale.id}" method="post">
                        <div class="profile">
                            <div class="profilePic">
                                <img src="${utente.URLimmagine}">
                            </div>
                            <c:if test="${utente.id != bachecaPersonale.id}">
                                <div class="profileName">
                                    <h2>${utente.nome} a ${bachecapersonale.nome}</h2>
                                </div>
                            </c:if>
                            <c:if test="${utente.id == bachecaPersonale.id}">
                                <div class="profileName">
                                    <h2>${utente.nome}</h2>
                                </div>
                            </c:if>
                        </div>
                        <div class="profileContent">
                            <c:if test="${post_rev.text != ''}">
                                <p>${post_rev.text}</p>
                            </c:if>
                            <c:if test="${post_rev.image != ''}">
                                <img src="${post_rev.image}">
                            </c:if>
                        </div>

                        <button>
                            Conferma
                        </button>

                    </form>
                </div>
            </c:if> 
        </div>
        </c:if>
    <c:if test="${loggedIn == null}">
        <div>
            Accesso Negato
        </div>
    </c:if>
    </body>
    
</html>
