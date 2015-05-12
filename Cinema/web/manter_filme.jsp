<%@page import="javax.jms.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cinema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/manutencao.css"/>
        <link rel="stylesheet" type="text/css" href="css/principal.css"/>  
        <script type="text/javascript" src="js/clock.js"></script>
    </head>
    <body>
        <header>
            <%@ include file= "header.jsp" %>
            <h1>Manutenção de Filmes</h1>
            <%@include file="manutencao.jsp"%>
        </header>
        <section>
            <div class="modulo">    
                <p><a id="1">Buscar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Nome do Filme" name="filme" required/></br>
                    <input type="hidden" name="command" value="BuscaFilme_F"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">    
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Buscar por Genero" name="genero" required/></br>
                    <input type="hidden" name="command" value="BuscaFilme_G"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">    
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Buscar por Diretor" name="diretor" required/></br>
                    <input type="hidden" name="command" value="BuscaFilme_D"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">    
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Buscar por Ator" name="ator" required/></br>
                    <input type="hidden" name="command" value="BuscaFilme_A"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            
            <div class="modulo">
                <p><a id="2">Criar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Idioma" name="idioma" required/></br>
                    <input type="number" placeholder="duração" name="duracao" required/></br>
                    <input type="number" placeholder="Ano" name="ano" required/></br>
                    <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                    <select name="diretor">
                        <option value="" selected="">-- Diretor --</option>
                        <c:forEach var="diretor" items="${diretores}" >
                            <option value="${diretor.getPk()}">${diretor.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="genero">
                        <option value="" selected="">-- Genero --</option>
                        <c:forEach var="genero" items="${generos}" >
                            <option value="${genero.getPk()}">${genero.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="distribuidora">
                        <option value="" selected="">-- Distribuidora --</option>
                        <c:forEach var="distribuidora" items="${distribuidoras}" >
                            <option value="${distribuidora.getPk()}">${distribuidora.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="listadeatores">
                        <option value="" selected="">-- Lista de Atores --</option>
                        <c:forEach var="la" items="${latores}" >
                            <option value="${la.getPk()}">${la.getPk()}</option> 
                        </c:forEach>    
                    </select>                    
                    <select name="situacao">
                        <option>Cartaz</option>
                        <option>Estreia</option>
                        <option>Lancamento</option>
                    </select></br>
                    <input type="hidden" name="command" value="FilmeCommand_Cria"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected="">-- Filme --</option>
                        <c:forEach var="filme" items="${filmes}" >
                            <option value="${filme.getPk()}">${filme.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Idioma" name="idioma" required/></br>
                    <input type="number" placeholder="duração" name="duracao" required/></br>
                    <input type="number" placeholder="Ano" name="ano" required/></br>
                    <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                    <select name="diretor">
                        <option value="" selected="">-- Diretor --</option>
                        <c:forEach var="diretor" items="${diretores}" >
                            <option value="${diretor.getPk()}">${diretor.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="genero">
                        <option value="" selected="">-- Genero --</option>
                        <c:forEach var="genero" items="${generos}" >
                            <option value="${genero.getPk()}">${genero.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="distribuidora">
                        <option value="" selected="">-- Distribuidora --</option>
                        <c:forEach var="distribuidora" items="${distribuidoras}" >
                            <option value="${distribuidora.getPk()}">${distribuidora.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <select name="listadeatores">
                        <option value="" selected="">-- Lista de Atores --</option>
                        <c:forEach var="la" items="${latores}" >
                            <option value="${la.getPk()}">${la.getPk()}</option> 
                        </c:forEach>    
                    </select>                    
                    <select name="situacao">
                        <option>Cartaz</option>
                        <option>Estreia</option>
                        <option>Lancamento</option>
                    </select></br>
                    <input type="hidden" name="command" value="MudaFilme"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="4">Deletar:</a></p></br>
                <form name="command" action="FrontController" method="POST">
                    <select name="codigo">
                        <option value="" selected="">-- Filme --</option>
                        <c:forEach var="filme" items="${filmes}" >
                            <option value="${filme.getPk()}">${filme.getNome()}</option> 
                        </c:forEach>    
                    </select>
                    <input type="hidden" name="command" value="FilmeCommand_Deleta"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>