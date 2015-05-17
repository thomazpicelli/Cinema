package com.br.lp2.cinema.controller.commands;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class Encaminhar implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        try{
            switch(operacao){
                case "Sala":
                    response.sendRedirect("SalaController");	
                    break;
                case "Sessao":
                    response.sendRedirect("SessaoController");
                    break;
                case "Usuario":
                    response.sendRedirect("UsuarioController");
                    break;
                case "Filme":
                    response.sendRedirect("FilmeController");
                    break;
                default:
                    response.sendRedirect("/principal_gerente.jsp");
            }
        } catch(IOException ex){
            ex.getMessage();
        }
    }
}