<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <title>Cinema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/acesso.css"/>
    </head>
    <body>
        <header>
            <c:remove var="nome"></c:remove>
        </header>
        <section>
            <c:if test="${nlogin != null && nlogin != ''}">
                <p class="invalido">Login Inválido</p>
            </c:if>
            <fieldset class="login">
                <p>Login</p>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Login" name="nome" required/></br>
                    <input type="password" placeholder="Senha" name="senha" required/></br>  
                    <input type="hidden" name="command" value="Login_x"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form"/>
                </form>
            </fieldset> 
        </section>
        <footer>
        </footer>
    </body>
</html>