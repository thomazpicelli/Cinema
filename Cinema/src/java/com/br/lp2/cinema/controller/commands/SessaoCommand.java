package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.ListaIngressosDAOconcreto;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.*;
import java.io.IOException;
import java.util.ArrayList;
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
            case "Encaminhar":
                ArrayList<Sessao> lista1 = new ArrayList<Sessao>();
                GenericDAO sessao1 = new SessaoDAOconcreto();
                lista1 = sessao1.read();
                request.getSession().setAttribute("sessoes", lista1);

                ArrayList<Filme> lista2 = new ArrayList<Filme>();
                GenericDAO filme1 = new FilmeDAOconcreto();
                lista2 = filme1.read();
                request.getSession().setAttribute("filmes", lista2);

                ArrayList<Sala> lista3 = new ArrayList<Sala>();
                GenericDAO sala1 = new SalaDAOconcreto();
                lista3 = sala1.read();
                request.getSession().setAttribute("salas", lista3);

                ArrayList<ListaIngressos> lista4 = new ArrayList<ListaIngressos>();
                GenericDAO listaIngressos1 = new ListaIngressosDAOconcreto();
                lista4 = listaIngressos1.read();
                request.getSession().setAttribute("ingressos", lista4);
                resultado = false;
                break;
            case "Cria":
                filme = Integer.parseInt(request.getParameter("filme"));
                sala = Integer.parseInt(request.getParameter("sala"));
                listadeingressos = Integer.parseInt(request.getParameter("listadeingressos"));
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
            default:
                try {
                    response.sendRedirect("manter_sessao.jsp");
                } catch (IOException ex) { ex.getMessage(); }
        }   
        try{
            if(resultado)
                response.sendRedirect("sucesso.jsp");
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