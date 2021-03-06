<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </head>
    <body>
        <header>
            <c:if test="${SessaoSele == null}">
                <c:redirect url="vender_por_filme.jsp"></c:redirect> 
            </c:if>
            <%@ include file= "header.jsp" %>
            <h1>Vender Ingresso</h1>
        </header>
        <section>
            <a href="FrontController?command=VendaPorCommand_Filme">Voltar</a>
            <h2 style="padding-left: 20%"><c:out value="Sala ${SessaoSele.getSala().getPk()} - ${SessaoSele.getFilme().getNome()} - ${SessaoSele.getHorario()}"></c:out></h2>
            <hr>
            <h3>Cliente:</h3>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome do Cliente" required=""/>
                <input type="number" name="anonasc" placeholder="Ano de Nascimento" required=""/>
                <select name="tipocliente">
                    <option>-- TIPO DE CLIENTE --</option>
                    <option value="GERAL">GERAL</option>
                    <option value="CADEIRANTE">CADEIRANTE</option>
                    <option value="IDOSO">IDOSO</option>
                </select>
                <select name="tipoingresso">
                    <option>-- TIPO DE INGRESSO --</option>
                    <option value="INTEIRA">INTEIRA</option>
                    <option value="MEIA ENTRADA">MEIA ENTRADA</option>
                    <option></option>
                </select>
                <hr id="c">
                <c:forEach var="i" begin="0" end="${SessaoSele.getSala().getLotacao() - 1}">
                    <c:if test="${i%10==0}"> <br> </c:if>
                    <img alt="cadeira" src="img/cadeira${cadeiras.get(i)+1}.png" style="width: 60px" id="${i}" onclick="window.location = 'FrontController?command=Comprar_Cadeira&cadeira='+this.id+'&quantidade='+${SessaoSele.getSala().getLotacao()}"/>
                    <c:if test="${cadeiras.get(i)+1 == 2}"><input type="hidden" name="cad" value="${i}"/></c:if>    
                </c:forEach><br>
                <input type="hidden" name="command" value="Comprar_Ingresso">
                <input type="image" src="img/comprar.png" alt="Submit Form" style="border-radius: 6px"/>
            </form>
        </section>    
    </body>
</html>
