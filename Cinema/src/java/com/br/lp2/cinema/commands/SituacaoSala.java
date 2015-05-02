package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sala;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomazpicelli
 */
public class SituacaoSala implements Command{
    private int numero;
    private String situacao;
    private Sala.Situacao si;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        situacao  = request.getParameter("situacao");
        
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
        Sala sala = salaDAO.readSalaByNumero(numero);
        
        boolean update = salaDAO.updateSala(sala.getPk(), new Sala(sala.getNumero(), sala.getLotacao(), sala.getEspecial(), si));
        
        try{
            if(update)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sala.jsp");
        }catch (IOException ex){
            ex.getMessage();
        }
    }
}
