package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class ListaAtores implements Serializable{
    private int pk;
    private static ArrayList<InfoAtor> lista;

    public ListaAtores(int pk) {
        this.pk = pk;
    }
    
    public ListaAtores(int pk, ArrayList<InfoAtor> lista) {
        this.pk = pk;
    }

    public ListaAtores(ArrayList<InfoAtor> lista) {
        this.lista = lista;
    }
   
    public ArrayList<InfoAtor> getLista(){
        return lista;
    }

    @Override
    public String toString() {
        return "ListaAtores{" + '}';
    }
    
    public void adicionaAtor(Ator ator, Filme filme, String papel, String part){
        InfoAtor ia = new InfoAtor(ator, filme, papel, part);
        lista.add(ia);
    }
    
    public void removeAtor(Ator ator, Filme filme, String papel, String part){
        for (InfoAtor infoAtor : lista) {
            if(ator.compara(infoAtor.getAtor())){
                lista.remove(infoAtor);
            }
        }
    }
    
    public void substituiAtor(Ator ator1, Filme filme, Ator ator2, String papel, String part){
        removeAtor(ator1, filme, papel, part);
        adicionaAtor(ator2, filme, papel, part);
    }
    
    public boolean procuraAtor(Ator ator){
        boolean resp = false;
        for (InfoAtor infoAtor : lista) {
            if(ator.compara(infoAtor.getAtor()))
                resp = true;
        }
        return resp;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }
    
}
