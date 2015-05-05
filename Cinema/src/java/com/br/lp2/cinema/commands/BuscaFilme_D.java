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
public class BuscaFilme_D implements Command{
    private String diretor;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        diretor = request.getParameter("diretor");
        
        ArrayList<Filme> diretores = new ArrayList<Filme>();
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        diretores = filmeDAO.readFilmeByDiretor(diretor);
    }
}
