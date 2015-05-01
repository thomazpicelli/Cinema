package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sala;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class CriaSala implements Command{
    private int numero;
    private int lotacao;
    private int especial;
    private String situacao;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        lotacao = Integer.parseInt(request.getParameter("lotacao"));
        especial = Integer.parseInt(request.getParameter("especial"));
        situacao = request.getParameter("situacao");
        
        SalaDAO salaDAO = new SalaDAOconcreto();
        boolean insert = salaDAO.insertSala(new Sala(numero, lotacao, especial,Sala.Situacao.ESPERA));
        
        try {
            if(insert)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sala.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}