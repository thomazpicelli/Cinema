package com.br.lp2.cinema.model.javabeans;

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

    public Diretor(int pk) {
        this.pk = pk;
    }

    public Diretor( int pk, int codigo, String nome) {
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