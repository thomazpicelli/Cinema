package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Atendente extends Funcionario implements Serializable{
 
    public Atendente(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public Atendente(int pk, String nome, String login, String senha) {
        super(pk, nome, login, senha);
    }   
}