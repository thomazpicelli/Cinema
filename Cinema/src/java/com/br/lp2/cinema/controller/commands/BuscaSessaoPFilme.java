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
 * @author Thomaz
 */
public class BuscaSessaoPFilme implements Command{
    private int pk;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        
        pk = Integer.parseInt(request.getParameter("codigo"));
        
        ArrayList<Sessao> lista = new ArrayList<Sessao>();
        GenericDAO sessao = new SessaoDAOconcreto();
        lista = sessao.read();
        for (Sessao lista1 : lista) {
            if(lista1.getFilme().getPk() != pk){
                lista.remove(lista1);
            }
        }
        
        request.getSession().setAttribute("buscaSessaoPFilme", lista);
        
        try {	  
            response.sendRedirect("vender_ingresso.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}