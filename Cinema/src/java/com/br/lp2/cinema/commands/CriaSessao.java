package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngressos;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import java.sql.Time;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class CriaSessao implements Command{
    private int filme;
    private int sala;
    private long horario;
    private boolean legendado = false;
    private int listadeingressos;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        filme = Integer.parseInt(request.getParameter("filme"));
        sala = Integer.parseInt(request.getParameter("sala"));
        horario = Long.parseLong(request.getParameter("horario"));
        String legenda = request.getParameter("legendado");
        listadeingressos = Integer.parseInt(request.getParameter("listadeingressos"));

        if(legenda.equals("legendado"))
            legendado = true;   
        
        SessaoDAO sessaoDAO = new SessaoDAOconcreto();
        boolean insert = sessaoDAO.insertSessao(new Sessao(new Filme(filme), new Sala(sala), new Time(horario), legendado, new ListaIngressos(listadeingressos)));
        try {
            if(insert)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sessao.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}