package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Cliente implements Serializable{
    private int pk;
    private String nome;
    private int anoNasc;
    private Especiais tipo;
    public enum Especiais{
        GERAL, CADEIRANTE, OBESO 
    }

    public Cliente(String nome, int anoNasc, Especiais tipo) {
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.tipo = tipo;
    }
    
    public Cliente(int pk, String nome, int anoNasc, Especiais tipo) {
        this.pk = pk;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.tipo = tipo;
    }

    public Cliente(int pk, String nome, int anoNasc, String tipo) {
        this.pk = pk;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.tipo = Enum.valueOf(Cliente.Especiais.class,tipo);
    }

    public Cliente(int pk, String nome, int anoNasc) {
        this.pk = pk;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.tipo = Especiais.GERAL;
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

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public Especiais getTipo() {
        return tipo;
    }

    public void setTipo(Especiais tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "pk=" + pk + ", nome=" + nome + ", anoNasc=" + anoNasc + ", tipo=" + tipo + '}';
    }   
}