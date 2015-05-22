package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.*;
import com.br.lp2.cinema.model.javabeans.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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

        if(situacao != null){
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
        }
        
        switch(operacao){
            case "Encaminhar":
                
                ArrayList<Diretor> lista1 = new ArrayList<>();
                GenericDAO diretor1 = new DiretorDAOconcreto();
                lista1 = diretor1.read();
                request.getSession().setAttribute("diretores", lista1);

                ArrayList<Genero> lista2 = new ArrayList<Genero>();
                GenericDAO genero1 = new GeneroDAOconcreto();
                lista2 = genero1.read();
                request.getSession().setAttribute("generos", lista2);

                ArrayList<Distribuidora> lista3 = new ArrayList<Distribuidora>();
                GenericDAO distribuidora1 = new DistribuidoraDAOconcreto();
                lista3 = distribuidora1.read();
                request.getSession().setAttribute("distribuidoras", lista3);

                ArrayList<InfoAtor> lista4 = new ArrayList<InfoAtor>();
                GenericDAO ia1 = new InfoAtorDAOconcreto();
                lista4 = ia1.read();
                request.getSession().setAttribute("latores", lista4);

                ArrayList<Ator> lista5 = new ArrayList<Ator>();
                GenericDAO ator1 = new AtorDAOconcreto();
                lista5 = ator1.read();
                request.getSession().setAttribute("atores", lista5);

                ArrayList<Filme> lista = new ArrayList<Filme>();
                GenericDAO filme1 = new FilmeDAOconcreto();
                lista = filme1.read();
                request.getSession().setAttribute("filmes", lista);

                resultado = false;
                
                break;
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