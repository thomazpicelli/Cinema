package com.br.lp2.cinema.commands;

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
        codigo = Integer.parseInt(request.getParameter("codigo"));
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
        }   
    }

    private boolean Cria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean Muda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean Deleta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
