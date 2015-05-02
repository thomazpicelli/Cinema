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
public class MudaSala implements Command{
    private int codigo;
    private int numero;
    private int lotacao;
    private int especial;
    private String situacao;
    private Sala.Situacao si;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        numero = Integer.parseInt(request.getParameter("numero"));
        lotacao = Integer.parseInt(request.getParameter("lotacao"));
        especial = Integer.parseInt(request.getParameter("especial"));
        situacao = request.getParameter("situacao");
        
        switch (situacao) {
            case "Manutencao":
                si = Sala.Situacao.MANUTENÇÃO;
                break;
            case "Exibicao":
                si = Sala.Situacao.EXIBICAO;
                break;
            case "Espera":
                si = Sala.Situacao.ESPERA;
                break;
        }

        SalaDAO salaDAO = new SalaDAOconcreto();
        boolean update = salaDAO.updateSala(codigo, new Sala(numero, lotacao, especial, si));
        
        try {    
            if(update)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sala.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}