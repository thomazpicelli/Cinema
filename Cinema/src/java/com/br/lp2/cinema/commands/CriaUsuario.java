package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.*;
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class CriaUsuario implements Command{
    private String nome;
    private String username;
    private String senha1;
    private String senha2;
    private String cargo;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        username = request.getParameter("username");
        senha1 = request.getParameter("senha1");
        senha2 = request.getParameter("senha2");
        cargo = request.getParameter("cargo");
        
        VerificadorCadastro vc = new VerificadorCadastro(username, senha1, senha2);
        boolean userName = vc.verificaUserName();
        boolean senha = vc.verificaSenha();
        
        if(!senha || userName){
            try {
                response.sendRedirect("./manter_usuario.html");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            if(cargo.contentEquals("Gerente")){
                GerenteDAO gerenteDAO = new GerenteDAOconcreto();
                gerenteDAO.insertGerente(new Gerente(nome, username, senha1));
            }
            else{
                AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
                atendenteDAO.insertAtendente(new Atendente(nome,username,senha1));
            }
            //sucesso
        }
    }
}
