package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.*;
import com.br.lp2.cinema.model.javabeans.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                nome = request.getParameter("nome");
                idioma = request.getParameter("idioma");
                duracao = Integer.parseInt(request.getParameter("duracao"));
                ano = Integer.parseInt(request.getParameter("ano"));
                classificacao = Integer.parseInt(request.getParameter("classificacao"));
                genero = Integer.parseInt(request.getParameter("genero"));
                diretor = Integer.parseInt(request.getParameter("diretor"));
                distribuidora = Integer.parseInt(request.getParameter("distribuidora"));
                listadeatores = Integer.parseInt(request.getParameter("listadeatores"));
                resultado = Cria();
                break;
            case "Muda": 
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nome = request.getParameter("nome");
                idioma = request.getParameter("idioma");
                duracao = Integer.parseInt(request.getParameter("duracao"));
                ano = Integer.parseInt(request.getParameter("ano"));
                classificacao = Integer.parseInt(request.getParameter("classificacao"));
                genero = Integer.parseInt(request.getParameter("genero"));
                diretor = Integer.parseInt(request.getParameter("diretor"));
                distribuidora = Integer.parseInt(request.getParameter("distribuidora"));
                listadeatores = Integer.parseInt(request.getParameter("listadeatores"));
                resultado = Muda();
                break;
            case "Deleta":
                codigo = Integer.parseInt(request.getParameter("codigo"));
                resultado = Deleta();
                break;
            default:
                try {
                    response.sendRedirect("manter_filme.jsp");
                } catch (IOException ex) { ex.getMessage(); }
        }   
     
        try{
            if(resultado)
                response.sendRedirect("sucesso.jsp");
            else
                response.sendRedirect("manter_filme.jsp");
        } catch(IOException ex){
            ex.getMessage();
        }  
    }
    
    private boolean Muda(){
        GenericDAO filmeDAO = new FilmeDAOconcreto();
        boolean update = filmeDAO.update(codigo, new Filme(new Diretor(diretor), new Genero(genero), new ListaAtores(listadeatores), new Distribuidora(distribuidora), nome, classificacao, ano, duracao, si, idioma));
        return update;
    }
    private boolean Cria(){
        GenericDAO filmeDAO = new FilmeDAOconcreto();
        boolean insert = filmeDAO.insert(new Filme(new Diretor(diretor), new Genero(genero), new ListaAtores(listadeatores), new Distribuidora(distribuidora), nome, classificacao, ano, duracao, si, idioma));
        return insert;
    }
    private boolean Deleta() {
        GenericDAO filmeDAO = new FilmeDAOconcreto();
        boolean delete = filmeDAO.delete(codigo);
        return delete;
    }
}