package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Diretor;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.javabeans.ListaAtores;
import java.io.IOException;

/**
 *
 * @author Thomaz
 */
public class FilmeCommand implements Command{
    private int codigo;
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
    private boolean resultado;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
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
        
        switch(operacao){
            case "Cria":
                resultado = Cria();
                break;
            case "Muda": 
                codigo = Integer.parseInt(request.getParameter("codigo"));
                resultado = Muda();
                break;
            case "Deleta":
                resultado = Deleta();
                break;
            case "Busca":
                break;
            default:
                try {
                    response.sendRedirect("manter_filme.jsp");
                } catch (IOException ex) { ex.getMessage(); }
        }   
     
        try{
            if(resultado)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_filme.jsp");
        } catch(IOException ex){
            ex.getMessage();
        }  
    }
    
    private boolean Muda(){
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        boolean update = filmeDAO.updateFilme(codigo, new Filme(new Diretor(diretor), new Genero(genero), new ListaAtores(listadeatores), new Distribuidora(distribuidora), nome, classificacao, ano, duracao, si, idioma));
        return update;
    }
    private boolean Cria(){
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        boolean insert = filmeDAO.insertFilme(new Filme(new Diretor(diretor), new Genero(genero), new ListaAtores(listadeatores), new Distribuidora(distribuidora), nome, classificacao, ano, duracao, si, idioma));
        return insert;
    }
    private boolean Deleta() {
        FilmeDAO filmeDAO = new FilmeDAOconcreto();
        boolean delete = filmeDAO.deleteFilme(codigo);
        return delete;
    }
}