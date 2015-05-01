<%-- 
    Document   : manter_sessao
    Created on : 26/04/2015, 01:07:52
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
                    <input type="number" placeholder="Filme" name="filme" required/></br>
                    <input type="number" placeholder="Sala" name="sala" required/></br>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<input type="radio" name="legendado" value="Legendado" checked="checked"/></br>
                    <input type="hidden" name="command" value="CriaSessao"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="number" placeholder="Filme" name="filme" required/></br>
                    <input type="number" placeholder="Sala" name="sala" required/></br>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<input type="radio" name="legendado" value="legendado" checked="checked"/></br>
                    <input type="hidden" name="command" value="MudaSessao"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="DeletaSessao"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>
