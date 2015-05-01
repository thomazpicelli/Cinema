package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class DeletaSessao implements Command{
    private int codigo;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getParameter("codigo");

        SessaoDAO sessaoDAO = new SessaoDAOconcreto();
        boolean delete = sessaoDAO.deleteSessao(codigo);

        try {    
            if(delete)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sessao.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }    
}