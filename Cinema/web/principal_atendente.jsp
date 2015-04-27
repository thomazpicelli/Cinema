<%-- 
    Document   : principal_atendente
    Created on : 26/04/2015, 00:37:00
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
        <script type="text/javascript" src="js/dropdown.js"></script>
        <script type="text/javascript" src="js/clock.js"></script>
    </head>
    <body>
        <header>
            <%
                session = request.getSession();
                if(session.getAttribute("nome")!=null && !session.getAttribute("nome").equals("")){
                    out.print("<p> Olá ");
                    out.print(session.getAttribute("nome"));
                    out.print(" ! Acesso Comercial.</p>");
                }
                else{
                    response.sendRedirect("./index.jsp");
                }
            %>    
            <p id="lugar" onload="Tempo()">---:---:---</p>
            <a href="./index.jsp">SAIR</a>
        </header>
        <section>
            <nav>
                <div class="dropdown hover">
                    <a href="#">Vender Ingresso</a>
                    <ul>
                        <li><a href="#">Por filme</a></li>
                        <li><a href="#">Por sessão</a></li>
                    </ul>
                </div>
            </nav>
        </section>
    </body>
</html>
