package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.*;
import com.br.lp2.cinema.model.javabeans.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomaz
 */
public class UsuarioCommand implements Command{
    private int codigo;
    private String nome;
    private String username;
    private String senha1;
    private String senha2;
    private String cargo;
    private boolean resultado;
    private String i = "";
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        nome = request.getParameter("nome");
        username = request.getParameter("username");
        senha1 = request.getParameter("senha1");
        senha2 = request.getParameter("senha2");
        cargo = request.getParameter("cargo");
        
        switch(operacao){
            case "Encaminhar":
                
                ArrayList<Funcionario> lista1 = new ArrayList<Funcionario>();
                ArrayList<Funcionario> lista2 = new ArrayList<Funcionario>();

                GenericDAO gerente = new GerenteDAOconcreto();
                GenericDAO atendente = new AtendenteDAOconcreto();
                lista1 = gerente.read();
                lista2 = atendente.read();
                for (Funcionario li : lista2) {
                    lista1.add(li);
                }

                request.getSession().setAttribute("usuarios", lista1);
                
                resultado = false;
                
                break;
            case "Busca":
                ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
                GenericDAO atendenteDAO = new AtendenteDAOconcreto();
                GenericDAO gerenteDAO = new GerenteDAOconcreto();

                if(request.getParameter("atendente")!= null)
                    lista.addAll(atendenteDAO.read());
                if(request.getParameter("gerente") != null)
                    lista.addAll(gerenteDAO.read());
                if(lista.isEmpty()){
                    if(request.getParameter("nome") != null){
                        nome = request.getParameter("nome");
                        Funcionario f = (Funcionario)atendenteDAO.readByNome(nome);
                        if(f == null){
                            f = (Funcionario) gerenteDAO.readByNome(nome);
                        }
                        lista.add(f);
                    }
                }

                request.getSession().setAttribute("buscaUsuario", lista);
                resultado = false;
                i = "#1";
                break;
            case "Cria":
                resultado = Cria();
                i = "#2";
                break;
            case "Muda": 
                codigo = Integer.parseInt(request.getParameter("codigo"));
                resultado = Muda();
                i = "#3";
                break;
            case "Deleta":
                resultado = Deleta();
                i = "#4";
                break;
            case "Cargo":
                resultado = Cargo();
                break;
                default:
                    try{ response.sendRedirect("./manter_usuario.jsp");
                    } catch(IOException ex){ ex.getMessage(); }
                    break;
        }   
        
        if(resultado){
            try{    
                response.sendRedirect("sucesso.jsp");
            } catch(IOException ex){
                ex.getMessage();
            }
        }
        else{
            try{    
                response.sendRedirect("manter_usuario.jsp"+i);
            } catch(IOException ex){
                ex.getMessage();
            }
        }
    }

    private boolean Cria() {
        boolean insert = false;
        VerificadorUsuario vc = new VerificadorUsuario(username, senha1, senha2);
        boolean userName = vc.verificaUserName();
        boolean senha = vc.verificaSenha(); 
        
        if(!senha || !userName) 
            return insert;
        else{
            if(cargo.equals("Gerente")){
                GenericDAO gerenteDAO = new GerenteDAOconcreto();
                insert = gerenteDAO.insert(new Gerente(nome, username, senha1));
            }
            else if(cargo.equals("Atendente")){
                GenericDAO atendenteDAO = new AtendenteDAOconcreto();
                insert = atendenteDAO.insert(new Atendente(nome,username,senha1));
            }
        }
        return insert;
    }

    private boolean Muda() {
        boolean update = false;
        VerificadorUsuario vc = new VerificadorUsuario(codigo, username, senha1, senha2, cargo);
        boolean userName = vc.verificaUserName();
        boolean senha = vc.verificaSenha();
        boolean codigo = vc.verificaCodgio();
        
        if(!senha || !userName || !codigo) 
            return update;
        else{
            if(cargo.equals("Gerente")){
                GenericDAO gerenteDAO = new GerenteDAOconcreto();
                update = gerenteDAO.update(this.codigo, new Gerente(nome, username, senha1));
            }
            else if(cargo.equals("Atendente")){
                GenericDAO atendenteDAO = new AtendenteDAOconcreto();
                update = atendenteDAO.update(this.codigo, new Atendente(nome,username,senha1));
            }
        }
        return update; 
    }

    private boolean Deleta() {
        boolean delete = false;
        GenericDAO gerenteDAO = new GerenteDAOconcreto();
        GenericDAO atendenteDAO = new AtendenteDAOconcreto();

        Funcionario funcionario = (Funcionario) atendenteDAO.readByNome(nome);
        if(funcionario != null)
            delete = atendenteDAO.delete(funcionario.getNome());
        else{
            funcionario = (Funcionario) gerenteDAO.readByNome(nome);
            if(funcionario != null)
                delete = gerenteDAO.delete(funcionario.getNome());
        }
        return delete;
    }    

    private boolean Cargo() {
        boolean delete, insert = false;
        GenericDAO gerenteDAO = new GerenteDAOconcreto();
        GenericDAO atendenteDAO = new AtendenteDAOconcreto();

        Funcionario funcionario = (Funcionario) atendenteDAO.readByNome(nome);
        if(funcionario != null){
            delete = atendenteDAO.delete(funcionario.getNome());
           if(delete) insert = gerenteDAO.insert(funcionario);
        }
        else{
            funcionario = (Funcionario) gerenteDAO.readByNome(nome);
            if(funcionario != null){
                delete = gerenteDAO.delete(funcionario.getNome());
                if(delete) insert = atendenteDAO.insert(funcionario);
            }
        }
        return insert;
    }
}