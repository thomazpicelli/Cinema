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
                    response.sendRedirect("manter_sala.jsp");	
                    break;
            }
        } catch(IOException ex){
            ex.getMessage();
        }
    }
}
