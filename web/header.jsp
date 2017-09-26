<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="barra">
            <header>
                <div id="title">
                    <h1>NerdBook</h1>
                </div>
            </header>
            <nav>
                <ol>
                    <li <c:if test="${active=='Bacheca'}">class="active"</c:if>><a href="Bacheca">Bacheca</a></li>
                    <li <c:if test="${active=='Descrizione'}">class="active"</c:if>><a href="./">Descrizione</a></li>
                    <li <c:if test="${active=='Profilo'}">class="active"</c:if>><a href="Profilo">Profilo</a></li>
                </ol>
            </nav>
            <div id="utente">
                <div id="login">
                    <a href="Login?logout=1">
                        <c:if test="${loggedIn!=null}">Logout</c:if>
                        <c:if test="${loggedIn==null}">Login</c:if>
                    </a>
                </div>
                <div id="nome">
                    <h3>${utente.nome}</h3>
                </div>
            </div>
</div>