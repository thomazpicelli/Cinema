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
            <h1>Manutenção de Sessão</h1>
            <%@include file="manutencao.jsp"%>
        </header>
        <section>
            <div class="modulo">    
                <p><a id="1">Buscar:</a></p></br>
                <form action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected=""> -- Código -- Filme -- Horário --</option>
                        <c:forEach var="sessao" items="${sessoes}" >
                            <option value="${sessao.getPk()}">${sessao.getPk()} - ${sessao.getFilme().getNome()} - ${sessao.getHorario()}</option> 
                        </c:forEach>    
                    </select><br>
                    Listar todos:<input type="checkbox" name="todos" value="sim"><br>
                    <input type="hidden" name="command" value="SessaoCommand_Busca">
                    <input type="image" src="img/enviar.png" alt="Submit Form"/>
                    <c:if test="${buscaSessao != null}">
                        <table>
                            <tr class="aa">
                                <td>CÓDIGO</td>
                                <td>FILME</td>
                                <td>SALA</td>
                                <td>HORÁRIO</td>
                                <td>LEGENDADO</td>
                            </tr>
                            <c:forEach var="sessao" items="${buscaSessao}">
                                <c:set var="l" value="NÃO"></c:set>
                                <c:if test="${sessao.isLegendado() == true}">
                                    <c:set var="l" value="SIM"></c:set>
                                </c:if>
                                <tr>
                                    <td>${sessao.getPk()}</td>
                                    <td>${sessao.getFilme().getNome()}</td>
                                    <td>${sessao.getSala().getNumero()}</td>
                                    <td>${sessao.getHorario()}</td>
                                    <td>${l}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </form>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form action="FrontController" method="POST">
                    <select name="filme">
                        <option value="" selected="">-- Filme --</option>
                        <c:forEach var="filme" items="${filmes}" >
                            <option value="${filme.getPk()}">${filme.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="sala">
                        <option value="" selected="">-- Sala --</option>
                        <c:forEach var="sala" items="${salas}" >
                            <option value="${sala.getPk()}">${sala.getNumero()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<br><br>
                    Sim:<input type="radio" name="legendado" value="legendado" checked=""/>
                    Não:<input type="radio" name="legendado" value=""/></br>
                    <input type="hidden" name="command" value="SessaoCommand_Cria"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected=""> -- Código -- </option>
                        <c:forEach var="sessao" items="${sessoes}" >
                            <option value="${sessao.getPk()}">${sessao.getPk()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="filme">
                        <option value="" selected="">-- Filme --</option>
                        <c:forEach var="filme" items="${filmes}" >
                            <option value="${filme.getPk()}">${filme.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="sala">
                        <option value="" selected="">-- Sala --</option>
                        <c:forEach var="sala" items="${salas}" >
                            <option value="${sala.getPk()}">${sala.getNumero()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<br><br>
                    Sim:<input type="radio" name="legendado" value="legendado" checked=""/>
                    Não:<input type="radio" name="legendado" value=""/></br>
                    <input type="hidden" name="command" value="SessaoCommand_Muda"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected=""> -- Código -- Filme -- Horário --</option>
                        <c:forEach var="sessao" items="${sessoes}" >
                            <option value="${sessao.getPk()}">${sessao.getPk()} - ${sessao.getFilme().getNome()} - ${sessao.getHorario()}</option> 
                        </c:forEach>    
                    </select><br>
                    <input type="hidden" name="command" value="SessaoCommand_Deleta"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form"/>
                </form>
            </div>
        </section>
    </body>
</html>
