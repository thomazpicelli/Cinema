package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class VendaSessaoCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        switch(operacao){
            case "Encaminhar":
            ArrayList<Sessao> lista = new ArrayList<Sessao>();
            GenericDAO sessao = new SessaoDAOconcreto();
            lista = sessao.read();
            request.getSession().setAttribute("vendersessao", lista);
            
            try {
                response.sendRedirect("vender_ingresso_sessao.jsp");
            } catch (IOException ex) {
                ex.getMessage();
            }
            break;
        }
    }    
}
