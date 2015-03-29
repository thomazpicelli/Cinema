package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.ListaAtores;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface ListaAtoresDAO{
    
    //CREATE
    public boolean insertListaAtores(ListaAtores listaAtores);
    
    //READ
    public ArrayList<ListaAtores> readListaAtores();
    public ListaAtores readListaAtoresById(int id);
    
    //UPDATE
    public boolean updateListaAtores(int id, ListaAtores listaAtores);
    
    //DELETE
    public boolean deleteListaAtores(int id);
    public boolean deleteListaAtores(ListaAtores listaAtores);    
}
