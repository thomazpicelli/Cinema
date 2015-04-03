package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.*;
import com.br.lp2.model.DAO.*;
import java.io.IOException;
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
        /*
        VerificadorLogin vl = new VerificadorLogin(new Usuario(nome,senha));
        boolean verificado = vl.verifica();
                */
        boolean verificado = false;
        RequestDispatcher rd;
        if(verificado) 
            rd = request.getRequestDispatcher("/principal_atendente.html");
        else 
            rd = request.getRequestDispatcher("/principal_gerente.html");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
        }
    }    
}