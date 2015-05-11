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
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Buscar" name="sessao" required/></br>
                    <input type="hidden" name="command" value="Sessao"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
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
                    <select name="listadeingressos">
                        <option value="" selected="">-- Ingressos Disponíveis --</option>
                        <c:forEach var="ing" items="${ingressos}" >
                            <option value="${ing.getPk()}">${ing.getPk()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<br><br>
                    Sim:<input type="radio" name="legendado" value="legendado" checked=""/>
                    Não:<input type="radio" name="legendado" value=""/></br>
                    <input type="hidden" name="command" value="SessaoCommand_Cria"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
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
                    <select name="listadeingressos">
                        <option value="" selected="">-- Ingressos Disponíveis --</option>
                        <c:forEach var="ing" items="${ingressos}" >
                            <option value="${ing.getPk()}">${ing.getPk()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<br><br>
                    Sim:<input type="radio" name="legendado" value="legendado" checked=""/>
                    Não:<input type="radio" name="legendado" value=""/></br>
                    <input type="hidden" name="command" value="SessaoCommand_Muda"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected=""> -- Código -- Filme -- Horário --</option>
                        <c:forEach var="sessao" items="${sessoes}" >
                            <option value="${sessao.getPk()}">${sessao.getPk()} - ${sessao.getFilme().getNome()} - ${sessao.getHorario()}</option> 
                        </c:forEach>    
                    </select><br>
                    <input type="hidden" name="command" value="SessaoCommand_Deleta"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>
