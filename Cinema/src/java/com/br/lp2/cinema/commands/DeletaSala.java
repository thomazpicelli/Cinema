package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class DeletaSala implements Command{
    private int codigo;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        
        SessaoDAO sessaoDAO = new SessaoDAOconcreto();
        Sessao sessao = sessaoDAO.readSessaoBySala(codigo);
        
        if(sessao == null){
            SalaDAO salaDAO = new SalaDAOconcreto();
            boolean delete = salaDAO.deleteSala(codigo);
        
            try {
                if(delete)
                    response.sendRedirect("sucesso.html");
                else
                    response.sendRedirect("principal_gerente.jsp");
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        else{
            try{
                response.sendRedirect("manter_sala.jsp");
            } catch (IOException ex){
                ex.getMessage();
            }
        }
    }
}