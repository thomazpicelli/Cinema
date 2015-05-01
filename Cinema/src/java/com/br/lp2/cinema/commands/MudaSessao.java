package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class MudaSessao implements Command{
    private int codigo;
    private int filme;
    private int sala;
    private String horario;
    private boolean legendado = false;
            
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        codigo = Integer.parseInt(request.getParameter("codigo"));
        filme = Integer.parseInt(request.getParameter("filme"));
        sala = Integer.parseInt(request.getParameter("sala"));
        horario = request.getParameter("horario");
        String legenda = request.getParameter("legendado");

        if(legenda.equals("legendado"))
            legendado = true;

        SessaoDAO sessaoDAO = new SessaoDAOconcreto();
        boolean update = sessaoDAO.updateSessao(codigo, new Sessao(null, null, null, legendado, null));
        
        try {    
            if(update)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sessao.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}