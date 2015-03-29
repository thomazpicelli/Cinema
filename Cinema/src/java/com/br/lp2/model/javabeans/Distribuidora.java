package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Distribuidora implements Serializable{
    private int pk;
    private String nome;

    public Distribuidora(int pk, String nome) {
        this.pk = pk;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Distribuidora{" + "pk=" + pk + ", nome=" + nome + '}';
    }
    
    
}
