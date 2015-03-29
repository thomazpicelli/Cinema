package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public abstract class Funcionario implements Serializable{
    private int pk;
    private String nome;
    private String login;
    private String senha;

    public Funcionario(int pk, String nome, String login, String senha) {
        this.pk = pk;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
