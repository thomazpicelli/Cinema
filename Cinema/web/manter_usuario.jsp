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
            <h1>Manutenção de Usuario</h1>
            <%@include file="manutencao.jsp"%>
        </header>
        <section>
            <div class="modulo">
                <form name="command" action="FrontController" method="POST">
                    <p>Mudar Cargo</p></br>
                    <select name="nome">
                        <option value="" selected="selected"> -- Usuários -- </option>
                        <c:forEach var="usuario" items="${usuarios}" >
                            <option value="${usuario.getNome()}">${usuario.getNome()}</option> 
                        </c:forEach>    
                    </select><br>
                    <input type="hidden" name="command" value="UsuarioCommand_Cargo"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">    
                <p><a id="1">Buscar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <select name="nome">
                        <option value="" selected="selected"> -- Usuários -- </option>
                        <c:forEach var="usuario" items="${usuarios}" >
                            <option value="${usuario.getNome()}">${usuario.getNome()}</option> 
                        </c:forEach>    
                    </select><br>
                    Listar Atendentes:<input type="checkbox" name="atendente" value="sim"><br>
                    Listar Gerentes:<input type="checkbox" name="gerente" value="sim"><br>
                    <input type="hidden" name="command" value="UsuarioCommand_Busca">
                    <input type="image" src="img/enviar.png" alt="Submit Form"/>
                    <c:if test="${buscaUsuario != null}">
                        <table>
                            <tr class="aa">
                                <td>CÓDIGO</td>
                                <td>NOME</td>
                                <td>USERNAME</td>
                                <td>SENHA</td>
                            </tr>
                            <c:forEach var="usuario" items="${buscaUsuario}">
                                <tr>
                                    <td>${usuario.getPk()}</td>
                                    <td>${usuario.getNome()}</td>
                                    <td>${usuario.getLogin()}</td>
                                    <td>${usuario.getSenha()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </form>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Login" name="username" required/></br>
                    <input type="password" placeholder="Senha" name="senha1" required/></br>
                    <input type="password" placeholder="Confirma Senha" name="senha2" required/></br>
                    <select name="cargo">
                        <option value="" selected=""> -- Cargo-- </option>
                        <option value="Atendente">Atendente</option> 
                        <option value="Gerente">Gerente</option> 
                    </select><br>
                    <input type="hidden" name="command" value="UsuarioCommand_Cria"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected="selected"> -- Codigo - Usuários -- </option>
                        <c:forEach var="usuario" items="${usuarios}" >
                            <option value="${usuario.getPk()}">${usuario.getPk()} - ${usuario.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="cargo">
                        <option value="" selected=""> -- Cargo-- </option>
                        <option value="Atendente">Atendente</option> 
                        <option value="Gerente">Gerente</option> 
                    </select>
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Login" name="username" required/></br>
                    <span class="red">*</span><input type="password" placeholder="Senha" name="senha1" required/></br>
                    <span class="red">*</span><input type="password" placeholder="Confirma Senha" name="senha2" required/></br>
                    <input type="hidden" name="command" value="UsuarioCommand_Muda"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <select name="nome">
                        <option value="" selected="selected"> -- Usuários -- </option>
                        <c:forEach var="usuario" items="${usuarios}" >
                            <option value="${usuario.getNome()}">${usuario.getNome()}</option> 
                        </c:forEach>    
                    </select><br>
                    <input type="hidden" name="command" value="UsuarioCommand_Deleta"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>