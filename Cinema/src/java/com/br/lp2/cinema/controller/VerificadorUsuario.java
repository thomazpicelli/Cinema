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
public class VerificadorUsuario {
    private int codigo;
    private String username;
    private String senha1;
    private String senha2;
    private String cargoA; //atendente false, gerente true

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
            GerenteDAO gerenteDao = new GerenteDAOconcreto();
            ArrayList<Gerente> listaGerentes = gerenteDao.readGerente();
            System.out.println("GERENTE VERIFICACAO");
            for (Gerente gerente : listaGerentes) {
                System.out.println(gerente);
                if(gerente.getPk() == codigo){
                    verificado = true;
                    System.out.println("ACHOU O CODIGO DO ZÉEEEE");
                    break;
                } 
            }   
        }
        else{
            AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
            ArrayList<Atendente> listaAtendentes = atendenteDAO.readAtendente();
        
            for (Atendente atendente : listaAtendentes){
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
        
        boolean verificado = true;
        for (Gerente gerente : listaGerentes) {
            if(gerente.getLogin().equals(username)){    
                verificado = false;
                break;
            } 
        }
        if(!verificado){
            for (Atendente atendente : listaAtendentes) {
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
