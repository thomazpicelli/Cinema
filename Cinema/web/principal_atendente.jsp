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
            <%@include file= "header.jsp" %>
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