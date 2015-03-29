package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Sala implements Serializable{
    private int pk;
    private int numero;
    private int lotacao;
    private int especial;
    private Situacao situacao;
    public enum Situacao{
            MANUTENÇÃO, EXIBICAO, ESPERA
    }

    public Sala(int pk, int numero, int lotacao, int especial, Situacao situacao) {
        this.pk = pk;
        this.numero = numero;
        this.lotacao = lotacao;
        this.especial = especial;
        this.situacao = situacao;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getEspecial() {
        return especial;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
}
