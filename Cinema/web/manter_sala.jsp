<%-- 
    Document   : manter_sala
    Created on : 26/04/2015, 01:10:59
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
            <h1>Manutenção de Sala</h1>
            <nav>
                <ul>
                    <li><a href="#1">Buscar</a></li>
                    <li><a href="#2">Criar</a></li>
                    <li><a href="#3">Mudar</a></li>
                    <li><a href="#4">Deletar</a></li>
                </ul>	
            </nav>
        </header>
        <section>
            </br>
            <h2>Situação da Sala:</h2>
            <form name="command" action="FrontController" method="POST">
                <input type="number" placeholder="Número da Sala" name="sala" required/></br>
                <select name="Situação">
                    <option>Manutenção</option>
                    <option>Exibição</option>
                    <option>Espera</option>
                </select></br>
                <input type="hidden" name="command" value="Login"/>
                <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
            </form>
            <div class="modulo">    
                <p><a id="1">Buscar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Buscar" name="sala" required/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Número" name="numero" required/></br>
                    <input type="number" placeholder="Lotação" name="lotacao" required/></br>
                    <input type="number" placeholder="Especial" name="especial" required/></br>
                    <select name="Situação">
                        <option>Manutenção</option>
                        <option>Exibição</option>
                        <option>Espera</option>
                    </select></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sala" name="codigo" required/></br></br>
                    <input type="number" placeholder="Número" name="numero" required/></br>
                    <input type="number" placeholder="Lotação" name="lotacao" required/></br>
                    <input type="number" placeholder="Especial" name="especial" required/></br>
                    <select name="Situação">
                        <option>Manutenção</option>
                        <option>Exibição</option>
                        <option>Espera</option>
                    </select></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sala" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>
