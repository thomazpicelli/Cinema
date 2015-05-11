<%-- 
    Document   : principal_gerente
    Created on : 26/04/2015, 01:04:24
    Author     : Thomaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cinema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/dropdown.css"/>
        <link rel="stylesheet" type="text/css" href="css/principal.css"/>
        <script type="text/javascript" src="js/dropdown.js"></script>
        <script type="text/javascript" src="js/clock.js"></script>
    </head>
    <body>
        <header>
            <%@ include file= "header.jsp" %>
        </header>
        <section>
            <nav>
                <div class="dropdown hover">
                    <a href="#">Manutenção</a>
                    <ul>
                        <li><a href="SalaController">Manter Sala</a></li>
                        <li><a href="FilmeController">Manter Filme</a></li>
                        <li><a href="SessaoController">Manter Sessão</a></li>
                        <li><a href="UsuarioController">Manter Usuário</a></li>
                    </ul>
                </div>
                <div class="dropdown hover">
                    <a href="#">Vender Ingresso</a>
                    <ul>
                        <li><a href="vender_ingresso.html">Por Filme</a></li>
                        <li><a href="vender_ingresso.html">Por Sessão</a></li>
                    </ul>
                </div>
            </nav>
        </section>
    </body>
</html>
