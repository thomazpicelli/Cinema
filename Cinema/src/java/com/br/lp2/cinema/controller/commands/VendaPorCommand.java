package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class VendaPorCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        ArrayList<Sessao> l = new ArrayList<Sessao>();
        SessaoDAOconcreto s = new SessaoDAOconcreto();
        switch(operacao){
            case "Filme":    
                request.getSession().removeAttribute("BuscaSessaoPF");
                ArrayList<Filme> lista = new ArrayList<Filme>();
                GenericDAO filme = new FilmeDAOconcreto();
                lista = filme.read();

                request.getSession().setAttribute("venderfilmes", lista);

                try {
                    response.sendRedirect("vender_por_filme.jsp");
                } catch (IOException ex) {
                    ex.getMessage();
                }
                break;
            case "Sessao":
                request.getSession().removeAttribute("BuscaSessaoPS");
                ArrayList<Sessao> lista1 = new ArrayList<Sessao>();
                GenericDAO sessao = new SessaoDAOconcreto();
                lista1 = sessao.read();
                request.getSession().setAttribute("vendersessao", lista1);

                try {
                    response.sendRedirect("vender_por_sessao.jsp");
                } catch (IOException ex) {
                    ex.getMessage();
                }                
                break;
            case "BuscaF":
                int f = Integer.parseInt(request.getParameter("filme"));
                l = s.readByFilme(f);
                request.getSession().setAttribute("BuscaSessaoPF", l);
                try {
                    response.sendRedirect("vender_por_filme.jsp");
                } catch (IOException ex) {
                    ex.getMessage();
                }
                break;
            case "BuscaS":
                String sess = request.getParameter("sessao");
                l = s.readByHorario(sess);
                request.getSession().setAttribute("BuscaSessaoPS", l);
                try {
                    response.sendRedirect("vender_por_sessao.jsp");
                } catch (IOException ex) {
                    ex.getMessage();
                }
                break;
            case "Seleciona":
                int selecionada;
                String sele = request.getParameter("seleciona");
                if(sele != null){
                    selecionada = Integer.parseInt(sele);
                    SessaoDAOconcreto selec = new SessaoDAOconcreto();
                    Sessao sessaoselecionada = selec.readById(selecionada);
                    request.getSession().setAttribute("SessaoSele", sessaoselecionada);
                    try{
                        response.sendRedirect("vender_ingresso.jsp");
                    }catch(IOException ex){
                        ex.getMessage();
                    }
                }
                break;
        }
    }    
}
