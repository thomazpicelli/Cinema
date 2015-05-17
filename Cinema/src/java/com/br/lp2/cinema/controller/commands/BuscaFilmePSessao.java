package com.br.lp2.cinema.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomazpicelli
 */
public class BuscaFilmePSessao implements Command{
    private int pk;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        pk = Integer.parseInt(request.getParameter("codigo"));
        
        
    }
}
