<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cinema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/manutencao.css"/>
        <link rel="stylesheet" type="text/css" href="css/principal.css"/>
        <script type="text/javascript" src="js/clock.js"></script>
        <style>
            h1{
                margin: 5% 0% 0% 30%;
            }
            a{
                font-size: 20pt;
                text-decoration: none;
                color: #FF5E00;
                margin: 5% 0% 0% 42%;
                float: left;
            }
        </style>    
    </head>
    <body>  
        <header>
            <%@ include file= "header.jsp" %>
        </header>
        <h1>Compra realizada com sucesso!</h1>
        <c:choose>
            <c:when test="${cargo == 'gerente'}">
                <a href="principal_gerente.jsp">Voltar</a>
            </c:when>
            <c:otherwise>
                <c:choose>    
                    <c:when test="${cargo == 'atendente'}">
                        <a href="principal_atendente.jsp">Voltar</a>
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="index.jsp"></c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </body>
</html>