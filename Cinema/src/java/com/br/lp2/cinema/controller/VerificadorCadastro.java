package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class VerificadorCadastro {
    private String username;
    private String senha1;
    private String senha2;

    public VerificadorCadastro(String username, String senha1, String senha2) {
        this.username = username;
        this.senha1 = senha1;
        this.senha2 = senha2;
    }
    
    public boolean verificaUserName(){
        GerenteDAO gerenteDao = new GerenteDAOconcreto();
        ArrayList<Gerente> listaGerentes = gerenteDao.readGerente();
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
        ArrayList<Atendente> listaAtendentes = atendenteDAO.readAtendente();
        
        boolean verificado = false;
        for (Gerente gerente : listaGerentes) {
            if(gerente.getLogin().equals(username)){    
                verificado = true;
                break;
            } 
        }
        if(!verificado){
            for (Atendente atendente : listaAtendentes) {
                if(atendente.getLogin().equals(username)){
                    verificado = true;
                    break;
                }
            }
        }
        return verificado;
    }
    public boolean verificaSenha(){
        boolean verificado = this.senha1.equals(senha2);
        return verificado;
    }
}
