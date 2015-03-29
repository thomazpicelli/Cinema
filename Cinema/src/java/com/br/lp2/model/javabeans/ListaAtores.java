package com.br.lp2.model.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class ListaAtores implements Serializable{
    private int pk;
    private static ArrayList<InfoAtor> lista;

    public ListaAtores() {
        lista = new ArrayList<InfoAtor>();
    }
    
    public ArrayList<InfoAtor> getLista(){
        return lista;
    }

    @Override
    public String toString() {
        return "ListaAtores{" + '}';
    }
    
    public void adicionaAtor(Ator ator, String papel, String part){
        InfoAtor ia = new InfoAtor(ator, papel, part);
        lista.add(ia);
    }
    
    public void removeAtor(Ator ator, String papel, String part){
        for (InfoAtor infoAtor : lista) {
            if(ator.compara(infoAtor.getAtor())){
                lista.remove(infoAtor);
            }
        }
    }
    
    public void substituiAtor(Ator ator1, Ator ator2, String papel, String part){
        removeAtor(ator1, papel, part);
        adicionaAtor(ator2, papel, part);
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
