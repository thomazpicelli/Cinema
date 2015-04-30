<%-- 
    Document   : manter_filme
    Created on : 26/04/2015, 01:11:44
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
            <h1>Manutenção de Filmes</h1>
            <nav>
                <ul>
                    <%
                        if(session.getAttribute("cargo").equals("gerente"))
                            out.print("<li class='principal'><a href='principal_gerente.jsp'>Principal</a></li>");
                        else if(session.getAttribute("cargo").equals("atendente"))
                            out.print("<li class='principal'><a href='principal_atendente.jsp'>Principal</a></li>");
                        else
                            response.sendRedirect("./index.jsp");
                    %>
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
                    <input type="text" placeholder="Buscar" name="filme" required/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Idioma" name="idioma" required/></br>
                    <input type="text" placeholder="Situação" name="situacao" required/></br>
                    <input type="number" placeholder="duração" name="duracao" required/></br>
                    <input type="number" placeholder="Ano" name="ano" required/></br>
                    <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                    <input type="number" placeholder="Diretor" name="diretor" required/></br>
                    <input type="number" placeholder="Genero" name="genero" required/></br>
                    <input type="number" placeholder="Distribuidora" name="distribuidora" required/></br>
                    <input type="number" placeholder="Lista de Atores" name="listaaores" required/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo do filme" name="codigo" required/></br></br>
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Idioma" name="idioma" required/></br>
                    <input type="text" placeholder="Situação" name="situacao" required/></br>
                    <input type="number" placeholder="duração" name="duracao" required/></br>
                    <input type="number" placeholder="Ano" name="ano" required/></br>
                    <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                    <input type="number" placeholder="Diretor" name="diretor" required/></br>
                    <input type="number" placeholder="Genero" name="genero" required/></br>
                    <input type="number" placeholder="Distribuidora" name="distribuidora" required/></br>
                    <input type="number" placeholder="Lista de Atores" name="listaaores" required/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo do filme" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>