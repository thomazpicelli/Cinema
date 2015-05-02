package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Gerente extends Funcionario implements Serializable{

    public Gerente(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public Gerente(int pk, String nome, String login, String senha) {
        super(pk, nome, login, senha);
    }   
          
}
