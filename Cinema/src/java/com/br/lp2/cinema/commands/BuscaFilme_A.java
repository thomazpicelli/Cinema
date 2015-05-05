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
public class BuscaFilme_A implements Command{
    private String ator;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ator = request.getParameter("ator");
        
        ArrayList<Filme> atores = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        atores = filmeDAO.readFilmeByAtor(ator);
    }
}
