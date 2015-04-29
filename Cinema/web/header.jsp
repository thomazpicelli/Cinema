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
