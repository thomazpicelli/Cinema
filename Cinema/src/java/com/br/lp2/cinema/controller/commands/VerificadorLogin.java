package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Funcionario;
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
        GenericDAO gerenteDao = new GerenteDAOconcreto();
        ArrayList<Funcionario> listaGerentes = gerenteDao.read();
        
        boolean verificado = false;
        for (Funcionario gerente : listaGerentes) {
            if(gerente.getLogin().equals(nome) && gerente.getSenha().equals(senha)){    
                verificado = true;
                break;
            } 
        }
        return verificado;
    }
    
    public boolean verificaAtendente(){
        GenericDAO atendenteDAO = new AtendenteDAOconcreto();
        ArrayList<Funcionario> listaAtendentes = atendenteDAO.read();
        
        boolean verificado = false;
        if(!verificado){
            for (Funcionario atendente : listaAtendentes) {
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
