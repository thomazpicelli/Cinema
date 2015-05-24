<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <%@ include file= "header.jsp" %>
            <h1>Vender por Filme</h1>
        </header>
        
        <section>
            
            <form action="FrontController" method="POST"> 
                <select name="filme">
                    <option value="" selected="">-- Selecione o Filme --</option>
                    <c:forEach var="filme" items="${venderfilmes}" >
                        <option value="${filme.getPk()}">${filme.getNome()}</option> 
                    </c:forEach>    
                </select><br>
                <input type="hidden" name="command" value="VendaPorCommand_BuscaF"/>
                <input type="image" src="img/enviar.png" alt="Submit Form"/>
            </form>
            <c:if test="${BuscaSessaoPF != null}">
                <h3>Sessões Disponíveis:</h3>
                <table>
                    <tr class="aa">
                        <td>CÓDIGO</td>
                        <td>FILME</td>
                        <td>SALA</td>
                        <td>HORÁRIO</td>
                        <td>LEGENDADO</td>
                        <td>IR</td>
                    </tr>
                    <form action="FrontController" method="POST">
                        <c:forEach var="sessao" items="${BuscaSessaoPF}">
                            <tr>
                                <td>${sessao.getPk()}</td>
                                <td>${sessao.getFilme().getNome()}</td>
                                <td>${sessao.getSala().getNumero()}</td>
                                <td>${sessao.getHorario()}</td>
                                <td>${sessao.isLegendado()}</td>
                                <td><input type="radio" name="seleciona" value="${sessao.getPk()}"></td>
                            </tr>
                        </c:forEach>
                        </table><br>
                        <input type="image" src="img/enviar.png" alt="Submit Form"/><br>
                        <input type="hidden" name="command" value="VendaPorCommand_Seleciona">
                    </form>
            </c:if>
        </section>
        <footer>
            
        </footer>
    </body>
</html>
