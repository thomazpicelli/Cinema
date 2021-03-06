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
            <h1>Manutenção de Sala</h1>
            <%@include file="manutencao.jsp"%>
        </header>
        <section>
            </br>
            <h2>Situação da Sala:</h2>
            Número:<form name="command" action="FrontController" method="POST">
                <select name="numero">
                    <option value="" selected="">-- Número --</option>
                    <c:forEach var="sala" items="${salas}" >
                        <option value="${sala.getNumero()}">${sala.getNumero()}</option> 
                    </c:forEach>    
                </select>
                <select name="situacao">
                    <option>Manutencao</option>
                    <option>Exibicao</option>
                    <option>Espera</option>
                </select></br>
                <input type="hidden" name="command" value="SalaCommand_MudaSituacao"/>
                <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
            </form>
            <div class="modulo">    
                <p><a id="1">Buscar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <select name="numero">
                        <option value="" selected="">-- Número --</option>
                        <c:forEach var="sala" items="${salas}" >
                            <option value="${sala.getNumero()}">${sala.getNumero()}</option> 
                        </c:forEach>    
                    </select></br>
                    Listar todos:<input type="checkbox" name="todos" value="sim"><br>
                    <input type="hidden" name="command" value="SalaCommand_Busca">
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
                <c:if test="${buscaSala != null}">
                    <table>
                        <tr class="aa">
                            <td>CÓDIGO</td>
                            <td>NÚMERO</td>
                            <td>LOTAÇÃO</td>
                            <td>ESPECIAL</td>
                            <td>SITUAÇÃO</td>
                        </tr>
                        <c:forEach var="sala" items="${buscaSala}">
                            <tr>
                                <td>${sala.getPk()}</td>
                                <td>${sala.getNumero()}</td>
                                <td>${sala.getLotacao()}</td>
                                <td>${sala.getEspecial()}</td>
                                <td>${sala.getSituacao()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Número" name="numero" required/></br>
                    <input type="number" placeholder="Lotação" name="lotacao" required/></br>
                    <input type="number" placeholder="Especial" name="especial" required/></br>
                    <select name="situacao">
                        <option>Manutencao</option>
                        <option>Exibicao</option>
                        <option>Espera</option>
                    </select></br>
                    <input type="hidden" name="command" value="SalaCommand_Cria"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                    <form name="command" action="FrontController" method="POST">    
                    <select name="codigo">
                        <option value="" selected="">-- Código --</option>
                        <c:forEach var="sala" items="${salas}" >
                            <option value="${sala.getPk()}">${sala.getPk()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="number" placeholder="Número" name="numero" required/></br>
                    <input type="number" placeholder="Lotação" name="lotacao" required/></br>
                    <input type="number" placeholder="Especial" name="especial" required/></br>
                    <select name="situacao">
                        <option>Manutencao</option>
                        <option>Exibicao</option>
                        <option>Espera</option>
                    </select></br>
                    <input type="hidden" name="command" value="SalaCommand_Muda"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <c:if test="${verificaSessao == 'sim'}">
                        Existe uma Sessão vinculada a esta sala! Operação inválida!
                    </c:if>
                    <select name="numero">
                        <option value="" selected="">-- Número --</option>
                        <c:forEach var="sala" items="${salas}" >
                            <option value="${sala.getNumero()}">${sala.getNumero()}</option> 
                        </c:forEach>    
                    </select><br>
                    <input type="hidden" name="command" value="SalaCommand_Deleta"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>
