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