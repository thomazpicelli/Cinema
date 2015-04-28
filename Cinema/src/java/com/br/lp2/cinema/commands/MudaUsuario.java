package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.VerificadorUsuario;
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class MudaUsuario implements Command{
    private int codigo;
    private String nome;
    private String username;
    private String senha1;
    private String senha2;
    private String cargo;
    private String cargoA;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        cargoA = request.getParameter("cargoA");
        nome = request.getParameter("nome");
        username = request.getParameter("username");
        senha1 = request.getParameter("senha1");
        senha2 = request.getParameter("senha2");
        cargo = request.getParameter("cargo");

        VerificadorUsuario vc = new VerificadorUsuario(codigo, username, senha1, senha2, cargoA);
        boolean userName = vc.verificaUserName();
        boolean senha = vc.verificaSenha();
        boolean codigo = vc.verificaCodgio();
        
        if(!senha || !userName || !codigo){
            try {
                response.sendRedirect("./manter_usuario.jsp");
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        else{
            boolean update;
            if(cargoA.equals("Gerente")){
                GerenteDAO gerenteDAO = new GerenteDAOconcreto();
                update = gerenteDAO.updateGerente(this.codigo, new Gerente(nome, username, senha1));
            }
            else{
                AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
                update = atendenteDAO.updateAtendente(this.codigo, new Atendente(nome,username,senha1));
            }
            if(update){
                try{    
                    response.sendRedirect("./sucesso.html");
                } catch(IOException ex){
                    ex.getMessage();
                }
            }
            else{
                try{    
                    response.sendRedirect("./manter_usuario.jsp");
                } catch(IOException ex){
                    ex.getMessage();
                }
            }
        }
    }
}
