<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="info">
                <h2>Persone</h2>
                <ol>
                    <c:forEach var="amico" items="${friends}">
                        <li>
                            <a href="Bacheca?bachecaid=${amico.id}">${amico.nome}</a>
                        </li>
                    </c:forEach>
                </ol>
            
                <h2>Gruppi</h2>
                <ol>
                    <c:forEach var="gruppo" items="${groups}">
                        <p>
                            ${gruppo.nome}
                        </p>
                    </c:forEach>
                </ol>
</div>