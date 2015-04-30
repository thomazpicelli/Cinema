<%-- 
    Document   : manter_usuario
    Created on : 26/04/2015, 01:06:13
    Author     : Thomaz
--%>

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
            <%@ include file= "header.jsp" %>
            <h1>Manutenção de Usuario</h1>
            <%@include file="manutencao.jsp"%>
        </header>
        <section>
            <div class="modulo">    
                <p><a id="1">Buscar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Buscar" name="usuario" required/></br>
                    <input type="hidden" name="command" value="Usuario"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Login" name="username" required/></br>
                    <input type="password" placeholder="Senha" name="senha1" required/></br>
                    <input type="password" placeholder="Confirma Senha" name="senha2" required/></br>
                    Gerente:  <input type="radio" name="cargo" value="Gerente"/>
                    Atendente:<input type="radio" name="cargo" value="Atendente"/></br>
                    <input type="hidden" name="command" value="CriaUsuario"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Código do Usuário que deseja alterar" name="codigo" required/></br>
                    <h3>Cargo Atual:</h3>
                    Gerente:  <input type="radio" name="cargoA" value="Gerente"/>
                    Atendente:<input type="radio" name="cargoA" value="Atendente"/></br>
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Login" name="username" required/></br>
                    <span class="red">*</span><input type="password" placeholder="Senha" name="senha1" required/></br>
                    <span class="red">*</span><input type="password" placeholder="Confirma Senha" name="senha2" required/></br>
                    Gerente:  <input type="radio" name="cargo" value="Gerente"/>
                    Atendente:<input type="radio" name="cargo" value="Atendente"/></br>
                    <input type="hidden" name="command" value="MudaUsuario"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <span class="red">*</span><input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="Usuario"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>