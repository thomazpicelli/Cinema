package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Ingresso implements Serializable{
    private int pk;
    private int id;
    private boolean inteira;
    private Cliente.Especiais tipo;

    public Ingresso(int pk, int id, boolean inteira, Cliente.Especiais tipo) {
        this.pk = pk;
        this.id = id;
        this.inteira = inteira;
        this.tipo = tipo;
    }

    public Ingresso(int pk, int id, boolean inteira) {
        this.pk = pk;
        this.id = id;
        this.inteira = inteira;
        this.tipo = Cliente.Especiais.GERAL;
    }

    public Ingresso(int pk, int id) {
        this.pk = pk;
        this.id = id;
        this.inteira = true;
        this.tipo = Cliente.Especiais.GERAL;
    }
    
    public boolean compara(Ingresso i){
        return i.getPk() == this.pk && i.getId() == this.id && i.isInteira() == this.inteira && i.getTipo() == this.tipo;
    }
    
    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInteira() {
        return inteira;
    }

    public void setInterira(boolean inteira) {
        this.inteira = inteira;
    }

    public Cliente.Especiais getTipo() {
        return tipo;
    }

    public void setTipo(Cliente.Especiais tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ingresso{" + "pk=" + pk + ", id=" + id + ", interira=" + inteira + ", tipo=" + tipo + '}';
    }
    
}
