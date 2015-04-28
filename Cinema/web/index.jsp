<%-- 
    Document   : index
    Created on : 25/04/2015, 23:16:53
    Author     : Thomaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cinema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/padrao.css"/>
        <link rel="stylesheet" type="text/css" href="css/acesso.css"/>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <header>
            <% session.removeAttribute("nome"); %>
        </header>
        <section>
            <% if(session.getAttribute("nlogin")!=null && !session.getAttribute("nlogin").equals("")){
                    out.print("<p> Login Inválido</p>");
                }
            %>
            <fieldset class="login">
                <p>Login</p>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Login" name="nome" required/></br>
                    <input type="password" placeholder="Senha" name="senha" required/></br>  
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </fieldset> 
        </section>
        <footer>
            
            
        </footer>
    </body>
</html>
