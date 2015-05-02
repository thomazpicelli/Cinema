package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomazpicelli
 */
public class CriaFilme implements Command{
    private String nome;
    private String idioma;
    private int duracao;
    private int ano;
    private int classificacao;
    private int genero;
    private int distribuidora;
    private int diretor;
    private int listadeatores;
    private String situacao;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        idioma = request.getParameter("idioma");
        duracao = Integer.parseInt(request.getParameter("duracao"));
        ano = Integer.parseInt(request.getParameter("ano"));
        classificacao = Integer.parseInt(request.getParameter("classificacao"));
        genero = Integer.parseInt(request.getParameter("genero"));
        distribuidora = Integer.parseInt(request.getParameter("distribuidora"));
        listadeatores = Integer.parseInt(request.getParameter("listadeatores"));
        situacao = request.getParameter("situacao");
        
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        boolean insert = filmeDAO.insertFilme(new Filme(null, null, null, null, nome, classificacao, ano, duracao, Filme.tiposituacao.CARTAZ, idioma));
        try{
            if(insert)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_filme.jsp");
        } catch(IOException ex){
            ex.getMessage();
        }        
    }
}