package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngressos;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomaz
 */
public class SessaoCommand implements Command{
    private int codigo;
    private int filme;
    private int sala;
    private String horario;
    private boolean legendado = false;
    private int listadeingressos;
    private boolean resultado;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        horario = request.getParameter("horario");
        String legenda = request.getParameter("legendado");
        if(legenda != null && legenda.equals("legendado"))
            legendado = true;  
        
        switch(operacao){
            case "Cria":
                filme = Integer.parseInt(request.getParameter("filme"));
                sala = Integer.parseInt(request.getParameter("sala"));
                listadeingressos = Integer.parseInt(request.getParameter("listadeingressos"));
                System.out.println(filme + " - " + sala + " - " + listadeingressos + " - " + horario);
                resultado = Cria();
                break;
            case "Muda": 
                codigo = Integer.parseInt(request.getParameter("codigo"));
                filme = Integer.parseInt(request.getParameter("filme"));
                sala = Integer.parseInt(request.getParameter("sala"));
                listadeingressos = Integer.parseInt(request.getParameter("listadeingressos"));
                resultado = Muda();
                break;
            case "Deleta":
                resultado = Deleta();
                break;
            case "Busca":
            default:
                try {
                    response.sendRedirect("manter_sessao.jsp");
                } catch (IOException ex) { ex.getMessage(); }
        }   
        try{
            if(resultado)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sessao.jsp");
        } catch(IOException ex){
            ex.getMessage();
        }          
    }
    private boolean Cria(){
        GenericDAO sessaoDAO = new SessaoDAOconcreto();
        boolean insert = sessaoDAO.insert(new Sessao(new Filme(filme), new Sala(sala),horario, legendado, new ListaIngressos(listadeingressos)));
        return insert;
    }
    private boolean Muda() {
        GenericDAO sessaoDAO = new SessaoDAOconcreto();
        boolean update = sessaoDAO.update(codigo, new Sessao(new Filme(filme), new Sala(sala), horario, legendado, new ListaIngressos(listadeingressos)));
        return update;
    }
    private boolean Deleta() {
        GenericDAO sessaoDAO = new SessaoDAOconcreto();
        boolean delete = sessaoDAO.delete(codigo);
        return delete;
    }
}