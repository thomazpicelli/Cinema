package com.br.lp2.cinema.commands;

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
 * @author Thomazpicelli
 */
public class MudaCargo implements Command{
    private String nome;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");

        GerenteDAO gerenteDAO = new GerenteDAOconcreto();
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();

        Funcionario funcionario = atendenteDAO.readAtendenteByNome(nome);
        if(funcionario == null)
            funcionario = gerenteDAO.readGerenteByNome(nome);
        
        boolean delete, insert = false;
        if(funcionario instanceof Atendente){
           delete = atendenteDAO.deleteAtendente(funcionario);
           if(delete) insert = gerenteDAO.insertGerente(funcionario);
        }
        else if(funcionario instanceof Gerente){
            delete = gerenteDAO.deleteGerente(funcionario);
            if(delete) insert = atendenteDAO.insertAtendente(funcionario);
        }
        try{
            if(insert)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_usuario.jsp");
        }catch(IOException ex){
            ex.getMessage();
        }
    }
}
