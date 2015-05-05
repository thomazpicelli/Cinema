<%-- 
    Document   : manter_filme
    Created on : 26/04/2015, 01:11:44
    Author     : Thomaz
--%>

<%@page import="javax.jms.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <% 
                
                
            %>
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
                    <input type="number" placeholder="Diretor" name="diretor" required/></br>
                    <input type="number" placeholder="Genero" name="genero" required/></br>
                    <input type="number" placeholder="Distribuidora" name="distribuidora" required/></br>
                    <input type="number" placeholder="Lista de Atores" name="listadeatores" required/></br>
                    <select name="situacao">
                        <option>Cartaz</option>
                        <option>Estreia</option>
                        <option>Lancamento</option>
                    </select></br>
                    <input type="hidden" name="command" value="CriaFilme"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
            <div class="modulo">
                <p><a id="3">Mudar:</a></p></br>
                
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo do filme" name="codigo" required/></br></br>
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="text" placeholder="Idioma" name="idioma" required/></br>
                    <input type="number" placeholder="duração" name="duracao" required/></br>
                    <input type="number" placeholder="Ano" name="ano" required/></br>
                    <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                    <input type="number" placeholder="Diretor" name="diretor" required/></br>
                    <input type="number" placeholder="Genero" name="genero" required/></br>
                    <input type="number" placeholder="Distribuidora" name="distribuidora" required/></br>
                    <input type="number" placeholder="Lista de Atores" name="listadeatores" required/></br>
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
                    <input type="number" placeholder="Codigo do filme" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="DeletaFilme"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
        </section>
    </body>
</html>