package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class DeletaUsuario implements Command{
    private int codigo;
    private String cargo;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        cargo = request.getParameter("cargo");

        boolean delete = false;
        if(cargo.equals("Gerente")){
            GerenteDAO gerenteDAO = new GerenteDAOconcreto();
            delete = gerenteDAO.deleteGerente(codigo);
        }
        else if(cargo.equals("Atendente")){
            AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
            delete = atendenteDAO.deleteAtendente(codigo);
        }
        try {
            if (delete)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_usuario.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
