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
public class BuscaFilme_F implements Command{
    private String filme;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        filme = request.getParameter("filme");
        
        Filme resultado;
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        resultado = filmeDAO.readFilmeByNome(filme);
    }
}