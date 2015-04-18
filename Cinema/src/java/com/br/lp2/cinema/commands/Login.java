package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.*;
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
public class Login implements Command{
    private String nome;
    private String senha;
   
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        senha = request.getParameter("senha");

        VerificadorLogin vl = new VerificadorLogin(nome,senha);
        boolean verificaA, verificaG = false;
        verificaA = vl.verificaAtendente();
        if(!verificaA) verificaG = vl.verificaGerente();
            
        try {
            RequestDispatcher rd;
            if(verificaA)
                //rd = request.getRequestDispatcher("/principal_atendente.html");
                response.sendRedirect("./principal_atendente.html");
            else{
                if(verificaG)
                    //rd = request.getRequestDispatcher("/principal_gerente.html");
                    response.sendRedirect("./principal_gerente.html");
                else
                    //rd = request.getRequestDispatcher("/index.html");
                    response.sendRedirect("./index.html");
            }
            /*
            try {
            rd.forward(request, response);
            } catch (ServletException | IOException ex) {
            }
            */
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}