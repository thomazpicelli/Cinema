package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 * Informação sobre a participação do ator em um filme
 * @version 1.0
 * @author thomazpicelli
 */
public class InfoAtor implements Serializable{
    private int pk;
    private Ator ator;
    private Filme filme;
    private String Papel;
    private String part;

    public InfoAtor(int pk, Ator ator, Filme filme, String Papel, String part) {
        this.pk = pk;
        this.ator = ator;
        this.filme = filme;
        this.Papel = Papel;
        this.part = part;
    }

    public InfoAtor(Ator ator, Filme filme, String Papel, String part) {
        this.ator = ator;
        this.filme = filme;
        this.Papel = Papel;
        this.part = part;
    }

    public InfoAtor(int pk) {
        this.pk = pk;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getPapel() {
        return Papel;
    }

    public void setPapel(String Papel) {
        this.Papel = Papel;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

}
