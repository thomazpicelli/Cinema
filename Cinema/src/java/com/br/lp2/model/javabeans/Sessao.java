package com.br.lp2.model.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Sessao implements Serializable{
    private int pk;
    private Filme filme;
    private Sala sala;
    private Date horario;
    private boolean legendado;
    private ListaIngressos lista;

    public Sessao(int pk, Filme filme, Sala sala, Date horario, boolean legendado, ListaIngressos listaIngresso) {
        this.pk = pk;
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
        this.legendado = legendado;
        this.lista = listaIngresso;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    public ListaIngressos getLista() {
        return lista;
    }
    

    @Override
    public String toString() {
        return "Sessao{" + "pk=" + pk + ", filme=" + filme + ", sala=" + sala + ", horario=" + horario + ", legendado=" + legendado + ", lista=" + lista + '}';
    }

}
