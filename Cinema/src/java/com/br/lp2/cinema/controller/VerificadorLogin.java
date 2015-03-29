/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.controller;

import com.br.lp2.model.javabeans.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class VerificadorLogin {
    private Funcionario funcionario;

    public VerificadorLogin(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public boolean verifica()
    {
         dao = new UsuarioDAOconcreto();
        ArrayList<Usuario> listaUsuarios = dao.select();
        

        boolean verificado = false;
        for (Usuario user : listaUsuarios) {
            if(usuario.getUsername().equals(user.getUsername()) && usuario.getSenha().equals(user.getSenha()))
            {    
                verificado = true;
                break;
            } 
        }
        return verificado;
    }
    
}
