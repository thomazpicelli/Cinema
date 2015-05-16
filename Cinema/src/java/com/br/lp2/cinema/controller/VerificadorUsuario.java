package com.br.lp2.cinema.controller;

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
public class VerificadorUsuario {
    private int codigo;
    private String username;
    private String senha1;
    private String senha2;
    private String cargoA; //atendente false, gerente true

    public VerificadorUsuario(String username) {
        this.username = username;
    }

    public VerificadorUsuario(String username, String senha1, String senha2) {
        this.username = username;
        this.senha1 = senha1;
        this.senha2 = senha2;
    }

    public VerificadorUsuario(int codigo, String username, String senha1, String senha2, String cargoA){
        this.codigo = codigo;
        this.username = username;
        this.senha1 = senha1;
        this.senha2 = senha2;
        this.cargoA = cargoA;
    }

    public boolean verificaCodgio(){
        boolean verificado = false;
        if(cargoA.equals("Gerente")){
            GenericDAO gerenteDAO = new GerenteDAOconcreto();
            ArrayList<Funcionario> listaGerentes = gerenteDAO.read();
            for (Funcionario gerente : listaGerentes) {
                if(gerente.getPk() == codigo){
                    verificado = true;
                    break;
                } 
            }   
        }
        else{
            GenericDAO atendenteDAO = new AtendenteDAOconcreto();
            ArrayList<Funcionario> listaAtendentes = atendenteDAO.read();
        
            for (Funcionario atendente : listaAtendentes){
                if(atendente.getPk() == codigo){
                    verificado = true;
                    break;
                }
            }
        }
        return verificado;
    }
    
    public boolean verificaUserName(){
        GenericDAO gerenteDao = new GerenteDAOconcreto();
        ArrayList<Funcionario> listaGerentes = gerenteDao.read();
        GenericDAO atendenteDAO = new AtendenteDAOconcreto();
        ArrayList<Funcionario> listaAtendentes = atendenteDAO.read();
        
        boolean verificado = true;
        for (Funcionario gerente : listaGerentes) {
            if(gerente.getLogin().equals(username)){    
                verificado = false;
                break;
            } 
        }
        if(!verificado){
            for (Funcionario atendente : listaAtendentes) {
                if(atendente.getLogin().equals(username)){
                    verificado = false;
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