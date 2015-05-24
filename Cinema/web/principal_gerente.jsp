<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <%@include file= "header.jsp" %>
            <h1>Menu Principal</h1>
        </header>
        <section>
            <nav>
                <div class="dropdown hover">
                    <a href="#">Manutenção</a>
                    <ul>
                        <li><a href="FrontController?command=SalaCommand_Encaminhar">Manter Sala</a></li>
                        <li><a href="FrontController?command=FilmeCommand_Encaminhar">Manter Filme</a></li>
                        <li><a href="FrontController?command=SessaoCommand_Encaminhar">Manter Sessão</a></li>
                        <li><a href="FrontController?command=UsuarioCommand_Encaminhar">Manter Usuário</a></li>
                    </ul>
                </div>
                <div class="dropdown hover">
                    <a href="#">Vender Ingresso</a>
                    <ul>
                        <li><a href="FrontController?command=VendaPorCommand_Filme">Por Filme</a></li>
                        <li><a href="FrontController?command=VendaPorCommand_Sessao">Por Sessão</a></li>
                    </ul>
                </div>
            </nav>
        </section>
    </body>
</html>