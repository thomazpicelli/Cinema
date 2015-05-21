<nav>
    <ul>
        <c:choose>
            <c:when test="${cargo == 'gerente'}">
                <li class="principal"><a href="principal_gerente.jsp">Principal</a></li>
            </c:when>
            <c:otherwise>
                <c:choose>    
                    <c:when test="${cargo == 'atendente'}">
                        <li class="principal"><a href="principal_atendente.jsp">Principal</a></li>
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="index.jsp"></c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        <li><a href="#1">Buscar</a></li>
        <li><a href="#2">Criar</a></li>
        <li><a href="#3">Mudar</a></li>
        <li><a href="#4">Deletar</a></li>
    </ul>	
</nav>