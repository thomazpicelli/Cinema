package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 * Informação sobre a participação do ator em um filme
 * @version 1.0
 * @author thomazpicelli
 */
public class InfoAtor implements Serializable{
    private Ator ator;
    private String Papel;
    private String part;
    
    /**
    * 
    * @param ator Ator
    * @param Papel Personagem Reprsentado
    * @param part  participação do filme (coadjuvante, principal)
    */
    
    public InfoAtor(Ator ator, String Papel, String part) {
        this.ator = ator;
        this.Papel = Papel;
        this.part = part;
    }

    public Ator getAtor() {
        return ator;
    }

    public String getPapel() {
        return Papel;
    }

    public String getPart() {
        return part;
    }

    @Override
    public String toString() {
        return "InfoAtor{" + "ator=" + ator + ", Papel=" + Papel + ", part=" + part + '}';
    }

}
