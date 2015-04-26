package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class VerificadorCadastro {
    private int codigo;
    private String username;
    private String senha1;
    private String senha2;
    private boolean cargo; //atendente false, gerente true

    public VerificadorCadastro(String username, String senha1, String senha2) {
        this.username = username;
        this.senha1 = senha1;
        this.senha2 = senha2;
        this.cargo = false; //assume atendente 
    }

    public VerificadorCadastro(int codigo, String username, String senha1, String senha2) {
        this.codigo = codigo;
        this.username = username;
        this.senha1 = senha1;
        this.senha2 = senha2;
        this.cargo = false;
    }

    public boolean verificaCodgio(){
        GerenteDAO gerenteDao = new GerenteDAOconcreto();
        ArrayList<Gerente> listaGerentes = gerenteDao.readGerente();
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
        ArrayList<Atendente> listaAtendentes = atendenteDAO.readAtendente();
        
        boolean verificado = false;
        for (Gerente gerente : listaGerentes) {
            if(gerente.getPk() == codigo){
                cargo = true; //cargo é gerente
                break;
            } 
        }
        if(!verificado){
            for (Atendente atendente : listaAtendentes) {
                if(atendente.getPk() == codigo){
                    verificado = true;
                    break;
                }
            }
        }
        return verificado;
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
                cargo = true; //assume gerente
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

    public boolean isCargo() {
        return cargo;
    }
    
    public String SenhaMD5(){
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha1.getBytes()));  
        senha1 = hash.toString(16);  
        return senha1;  
    }
}
