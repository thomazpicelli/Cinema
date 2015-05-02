package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomazpicelli
 */
public class DeletaFilme implements Command{
    private int codigo;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        boolean delete = filmeDAO.deleteFilme(codigo);
        
        try{
            if(delete)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_filme.jsp");
        } catch(IOException ex){
            ex.getMessage();
        }
    }
}