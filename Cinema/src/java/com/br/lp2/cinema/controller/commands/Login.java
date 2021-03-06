package com.br.lp2.cinema.controller.commands;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thomazpicelli
 */
public class Login implements Command{
    private String nome;
    private String senha;
   
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        nome = request.getParameter("nome");
        senha = request.getParameter("senha");

        VerificadorLogin vl = new VerificadorLogin(nome,senha);
        boolean verificaA, verificaG = false;
        verificaA = vl.verificaAtendente();
        if(!verificaA) verificaG = vl.verificaGerente();
        
        HttpSession session = request.getSession();
        session.setAttribute("nome", nome);      
        session.setAttribute("nlogin", "");
        try {
            if(verificaA){
                session.setAttribute("cargo", "atendente");
                response.sendRedirect("./principal_atendente.jsp");
            }
            else if(verificaG){
                session.setAttribute("cargo", "gerente");
                response.sendRedirect("./principal_gerente.jsp");    
            }
            else{
                session.setAttribute("nlogin", "Inválido");                    
                response.sendRedirect("./index.jsp");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }    
}