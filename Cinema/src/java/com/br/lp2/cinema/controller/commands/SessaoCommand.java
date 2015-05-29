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
    private String i = "";
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        horario = request.getParameter("horario");
        String legenda = request.getParameter("legendado");
        if(legenda != null && legenda.equals("legendado"))
            legendado = true;  
        
        switch(operacao){
            case "Encaminhar":
                request.getSession().removeAttribute("buscaSessao");
                
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

                resultado = false;
                break;
            case "Busca":
                ArrayList<Sessao> lista = new ArrayList<Sessao>();
                GenericDAO sessao = new SessaoDAOconcreto();
                String todos = request.getParameter("todos");
                if(todos != null){
                    lista = sessao.read();
                    request.getSession().setAttribute("buscaSessao", lista);
                }
                else{
                    String pk = request.getParameter("sessao");
                    if(pk != null){ 
                        int id = Integer.parseInt(pk);
                        Sessao s = (Sessao)sessao.readById(id);
                        lista.add(s);
                        request.getSession().setAttribute("buscaSessao", lista);
                    }
                }
                resultado = false;
                i = "#1";
                break;
            case "Cria":
                filme = Integer.parseInt(request.getParameter("filme"));
                sala = Integer.parseInt(request.getParameter("sala"));
                resultado = Cria();
                i = "#2";
                break;
            case "Muda": 
                codigo = Integer.parseInt(request.getParameter("codigo"));
                filme = Integer.parseInt(request.getParameter("filme"));
                sala = Integer.parseInt(request.getParameter("sala"));
                resultado = Muda();
                i = "#3";
                break;
            case "Deleta":
                codigo = Integer.parseInt(request.getParameter("codigo"));
                resultado = Deleta();
                i = "#4";
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
                response.sendRedirect("manter_sessao.jsp"+i);
        } catch(IOException ex){
            ex.getMessage();
        }          
    }
    private boolean Cria(){
        GenericDAO sessaoDAO = new SessaoDAOconcreto();
        boolean insert = sessaoDAO.insert(new Sessao(new Filme(filme), new Sala(sala),horario, legendado));
        return insert;
    }
    private boolean Muda() {
        GenericDAO sessaoDAO = new SessaoDAOconcreto();
        boolean update = sessaoDAO.update(codigo, new Sessao(new Filme(filme), new Sala(sala), horario, legendado));
        return update;
    }
    private boolean Deleta() {
        GenericDAO sessaoDAO = new SessaoDAOconcreto();
        boolean delete = sessaoDAO.delete(codigo);
        return delete;
    }
}