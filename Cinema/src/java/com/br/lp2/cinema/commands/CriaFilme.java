package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Diretor;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.javabeans.ListaAtores;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomazpicelli
 */
public class CriaFilme implements Command{
    private String nome;
    private String idioma;
    private int duracao;
    private int ano;
    private int classificacao;
    private int genero;
    private int distribuidora;
    private int diretor;
    private int listadeatores;
    private String situacao;
    private Filme.tiposituacao si;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        idioma = request.getParameter("idioma");
        duracao = Integer.parseInt(request.getParameter("duracao"));
        ano = Integer.parseInt(request.getParameter("ano"));
        classificacao = Integer.parseInt(request.getParameter("classificacao"));
        genero = Integer.parseInt(request.getParameter("genero"));
        diretor = Integer.parseInt(request.getParameter("diretor"));
        distribuidora = Integer.parseInt(request.getParameter("distribuidora"));
        listadeatores = Integer.parseInt(request.getParameter("listadeatores"));
        situacao = request.getParameter("situacao");
        
        switch(situacao){
            case "Cartaz":
                si = Filme.tiposituacao.CARTAZ;
                break;
            case "Estreia":
                si = Filme.tiposituacao.ESTREIA;
                break;
            case "Lancamento":
                si = Filme.tiposituacao.LANÇAMENTO;
                break;  
        }
        
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        boolean insert = filmeDAO.insertFilme(new Filme(new Diretor(diretor), new Genero(genero), new ListaAtores(listadeatores), new Distribuidora(distribuidora), nome, classificacao, ano, duracao, si, idioma));
        try{
            if(insert)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_filme.jsp");
        } catch(IOException ex){
            ex.getMessage();
        }        
    }
}