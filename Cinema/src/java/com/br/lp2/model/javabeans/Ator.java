package com.br.lp2.model.javabeans;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Ator implements Serializable{
    private int pk;
    private String nome;
    private String nacionalidade;
    private Date datanasc;

    public Ator(int pk, String nome, String nacionalidade, Date datanasc) {
        this.pk = pk;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.datanasc = datanasc;
    }

    public int getPk() {
        return pk;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    @Override
    public String toString() {
        return "Ator{" + "pk=" + pk + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", datanasc=" + datanasc + '}';
    }
    
    public boolean compara(Ator a){
        if(a.getPk() == this.pk && a.getDatanasc() == this.datanasc && a.getNacionalidade().equalsIgnoreCase(this.nacionalidade)&& a.getNome().equalsIgnoreCase(this.nome))
            return true;
        else
            return false;
    }
}
