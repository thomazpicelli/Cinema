package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class BuscaFilme_G implements Command{
    private String genero;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        genero = request.getParameter("genero");
        
        ArrayList<Filme> generos = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        generos = filmeDAO.readFilmeByGenero(genero);
        
    }
}