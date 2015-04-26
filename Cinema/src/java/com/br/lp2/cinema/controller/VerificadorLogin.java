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
public class VerificadorLogin {
    private String nome;
    private String senha;

    public VerificadorLogin(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean verificaGerente(){
        GerenteDAO gerenteDao = new GerenteDAOconcreto();
        ArrayList<Gerente> listaGerentes = gerenteDao.readGerente();
        
        boolean verificado = false;
        for (Gerente gerente : listaGerentes) {
            if(gerente.getLogin().equals(nome) && gerente.getSenha().equals(senha)){    
                verificado = true;
                break;
            } 
        }
        return verificado;
    }
    
    public boolean verificaAtendente(){
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
        ArrayList<Atendente> listaAtendentes = atendenteDAO.readAtendente();
        
        boolean verificado = false;
        if(!verificado){
            for (Atendente atendente : listaAtendentes) {
                if(atendente.getLogin().equals(nome) && atendente.getSenha().equals(senha)){    
                    verificado = true;
                    break;
                } 
            }
        }
        return verificado;
    }
    
    public String SenhaMD5(){
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        senha = hash.toString(16);  
        return senha;  
    }
}
