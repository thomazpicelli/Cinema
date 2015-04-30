<%
    if(session.getAttribute("nome")!=null && !session.getAttribute("nome").equals("")){
        out.print("<p class='nome'> Olá ");
        out.print(session.getAttribute("nome"));
        if(session.getAttribute("cargo").equals("gerente"))
            out.print("! -  Acesso Total.</p>");
        else
            out.print("! -  Acesso Comercial.</p>");
    }
    else{
        response.sendRedirect("./index.jsp");
    }
%>    
<p class="nome" id="lugar" onload="Tempo()">---:---:---</p>
<p class="nome"><a href="./index.jsp">SAIR</a></p>
