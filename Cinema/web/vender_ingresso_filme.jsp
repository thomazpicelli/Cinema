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
        </header>
        <section>
            <form action="FrontController"> 
                <select name="codigo">
                    <option value="" selected="">-- Selecione o Filme --</option>
                    <c:forEach var="filme" items="${venderfilmes}" >
                        <option value="${filme.getPk()}">${filme.getNome()}</option> 
                    </c:forEach>    
                </select>
                <input type="hidden" name="command" value="BuscaSessaoPFilme_x"/>
                <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                <c:if test="${buscaSessaoPFilme != null}">
                    <table>
                        <tr class="aa">
                            <td>CÓDIGO</td>
                            <td>FILME</td>
                            <td>SALA</td>
                            <td>HORÁRIO</td>
                            <td>LEGENDADO</td>
                        </tr>
                        <c:forEach var="sessao" items="${buscaSessaoPFilme}">
                            <tr>
                                <td>${sessao.getPk()}</td>
                                <td>${sessao.getFilme().getNome()}</td>
                                <td>${sessao.getSala().getNumero()}</td>
                                <td>${sessao.getHorario()}</td>
                                <td>${sessao.isLegendado()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </form>
        </section>
        <footer>
            
        </footer>
    </body>
</html>
