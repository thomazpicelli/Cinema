package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class BuscaFilme implements Command{
    private String genero;
    private String filme;
    private String diretor;
    private String ator;
    private boolean resultado;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        ArrayList<Object> result = new ArrayList<Object>();
        switch(operacao){
            case "Filme":
                Filme filme = (Filme)Filme(request);
                break;
            case "Genero": 
                result = Genero(request);
                break;
            case "Diretor":
                result = Diretor(request);
                break;
            case "Ator":
                result = Ator(request);
                break;
            default:
                try {
                    response.sendRedirect("manter_filme.jsp");
                } catch (IOException ex) { ex.getMessage(); }
        }   
        
    }

    private Object Filme(HttpServletRequest request) {
        filme = request.getParameter("filme");
        
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        Filme resultado;
        return resultado = filmeDAO.readFilmeByNome(filme);
    }

    private ArrayList Genero(HttpServletRequest request) {
        genero = request.getParameter("genero");
        
        ArrayList<Filme> generos = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        return generos = filmeDAO.readFilmeByGenero(genero);
    }

    private ArrayList Diretor(HttpServletRequest request) {
        diretor = request.getParameter("diretor");
        
        ArrayList<Filme> diretores = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        return diretores = filmeDAO.readFilmeByDiretor(diretor);
    }

    private ArrayList Ator(HttpServletRequest request) {
        ator = request.getParameter("ator");
        
        ArrayList<Filme> atores = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        return atores = filmeDAO.readFilmeByAtor(ator);
    }
}