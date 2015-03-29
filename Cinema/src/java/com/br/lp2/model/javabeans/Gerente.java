package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Gerente extends Funcionario implements Serializable{

    public Gerente(int pk, String nome, String login, String senha) {
        super(pk, nome, login, senha);
    }
    
       
}
