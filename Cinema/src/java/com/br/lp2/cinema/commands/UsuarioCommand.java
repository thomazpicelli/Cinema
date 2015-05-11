package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.VerificadorUsuario;
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Funcionario;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.io.IOException;
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
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        nome = request.getParameter("nome");
        username = request.getParameter("username");
        senha1 = request.getParameter("senha1");
        senha2 = request.getParameter("senha2");
        cargo = request.getParameter("cargo");
        
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
                response.sendRedirect("./sucesso.html");
            } catch(IOException ex){
                ex.getMessage();
            }
        }
        else{
            try{    
                response.sendRedirect("./manter_usuario.jsp");
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
                GerenteDAO gerenteDAO = new GerenteDAOconcreto();
                insert = gerenteDAO.insertGerente(new Gerente(nome, username, senha1));
            }
            else if(cargo.equals("Atendente")){
                AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
                insert = atendenteDAO.insertAtendente(new Atendente(nome,username,senha1));
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
                GerenteDAO gerenteDAO = new GerenteDAOconcreto();
                update = gerenteDAO.updateGerente(this.codigo, new Gerente(nome, username, senha1));
            }
            else if(cargo.equals("Atendente")){
                AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
                update = atendenteDAO.updateAtendente(this.codigo, new Atendente(nome,username,senha1));
            }
        }
        return update; 
    }

    private boolean Deleta() {
        boolean delete = false;
        GerenteDAO gerenteDAO = new GerenteDAOconcreto();
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();

        Funcionario funcionario = atendenteDAO.readAtendenteByNome(nome);
        if(funcionario != null)
            delete = atendenteDAO.deleteAtendente(funcionario.getNome());
        else{
            funcionario = gerenteDAO.readGerenteByNome(nome);
            if(funcionario != null)
                delete = gerenteDAO.deleteGerente(funcionario.getNome());
        }
        return delete;
    }    

    private boolean Cargo() {
        boolean delete, insert = false;
        GerenteDAO gerenteDAO = new GerenteDAOconcreto();
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();

        Funcionario funcionario = atendenteDAO.readAtendenteByNome(nome);
        if(funcionario != null){
            delete = atendenteDAO.deleteAtendente(funcionario.getNome());
           if(delete) insert = gerenteDAO.insertGerente(funcionario);
        }
        else{
            funcionario = gerenteDAO.readGerenteByNome(nome);
            if(funcionario != null){
                delete = gerenteDAO.deleteGerente(funcionario.getNome());
                if(delete) insert = atendenteDAO.insertAtendente(funcionario);
            }
        }
        return insert;
    }
}
