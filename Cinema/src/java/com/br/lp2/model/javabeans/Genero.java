package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Genero implements Serializable{
    private transient int pk; //primary key, banco de dados, nao preciso de persista
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public Genero(int pk, String nome) {
        this.pk = pk;
        this.nome = nome;
    }

    public int getPk() {
        return pk;
    }

    public String getNome() {
        return nome;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" + "pk=" + pk + ", nome=" + nome + '}';
    }
            
}
