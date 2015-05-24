<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${cadeiras == null}">
            <c:redirect url="FrontController?command=init"></c:redirect>
        </c:if>
        Sala: <select onchange="window.location='FrontController?command=trocasala.'+this.value">
            <c:forEach var="i" begin="1" end="${salas.size()}">
                <c:choose>
                    <c:when test="${i== salas_selecionadas}">
                        <option value="${i}" selected="">${i}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${i}">${i}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        
        Sessão: <select>
            <c:forEach var="i" begin="1" end="${salas.get(salas_selecionadas).size()}">
                <option value="${i}">${i}</option>    
            </c:forEach>
        </select>
        <hr>
        <c:forEach var="i" begin="0" end="59">
            <c:if test="${i%10==0}"> <br> </c:if>
            <img alt="cadeira" src="img/cadeira${cadeiras.get(i)+1}.png" style="width: 60px" id="${i}" onclick="window.location = 'FrontController?command=selecionar.cad'+this.id"/>
        </c:forEach>
        
        <form action="FrontController" method="GET">
            <input type="submit" value="COMPRAR"/>
            <input type="hidden" name="command" value="comprar"/>
        </form>
    </body>
</html>
