<c:choose>
    <c:when test="${nome != null && nome != ''}">
        <p class='nome'> Olá <c:out value="${nome}"></c:out>
        <c:choose>
            <c:when test="${cargo == 'gerente'}">
                <c:out value=" - Acesso Total"></c:out>
            </c:when>    
            <c:otherwise>
                <c:out value=" - Acesso Comercial"></c:out>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <c:redirect url="index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>  
<p class="nome" id="lugar" onload="Tempo()">---:---:---</p>
<p class="nome"><a href="./index.jsp">SAIR</a></p>
