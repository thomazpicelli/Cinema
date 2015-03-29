package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Diretor implements Serializable{
    private int pk;
    private int codigo;
    private String nome;

    public Diretor(String nome) {
        this.nome = nome;
    }

    public Diretor(int codigo, String nome, int pk) {
        this.codigo = codigo;
        this.nome = nome;
        this.pk = pk;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getPk() {
        return pk;
    }

    @Override
    public String toString() {
        return "Diretor{" + "pk=" + pk + ", codigo=" + codigo + ", nome=" + nome + '}';
    }
    
}
