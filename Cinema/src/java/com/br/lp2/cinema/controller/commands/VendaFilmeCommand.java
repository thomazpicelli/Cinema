package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.javabeans.Filme;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class VendaFilmeCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        
        switch(operacao){
            case "Encaminhar":    
            ArrayList<Filme> lista = new ArrayList<Filme>();
            GenericDAO filme = new FilmeDAOconcreto();
            lista = filme.read();
            
            request.getSession().setAttribute("venderfilmes", lista);
            
            try {
                response.sendRedirect("vender_ingresso_filme.jsp");
            } catch (IOException ex) {
                ex.getMessage();
            }
            break;
        }
    }    
}
