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
        <link rel="stylesheet" type="text/css" href="css/manutencao.css"/> <!-- CSS ACESSO DE PRODUTOS -->
        <script type="text/javascript" src="js/clock.js"></script>
    </head>
    <body>
        <header>
            <%
                if(session.getAttribute("nome")!=null && !session.getAttribute("nome").equals("")){
                    out.print("<p> Olá ");
                    out.print(session.getAttribute("nome"));
                    out.print(" ! Acesso Total.</p>");
                }
                else{
                    response.sendRedirect("./index.jsp");
                }
            %>    
            <p id="lugar" onload="Tempo()">---:---:---</p>
            <a href="./index.jsp">SAIR</a>
            <h1>Manutenção de Sessão</h1>
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
                    <input type="hidden" name="command" value="Login"/>
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
                    Legendado:<input type="radio" name="legendado" value="Legendado" checked="checked"/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>