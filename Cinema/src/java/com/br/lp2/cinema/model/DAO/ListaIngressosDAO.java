package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.ListaIngressos;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface ListaIngressosDAO {
        
    //CREATE
    public boolean insertListaIngressos(ListaIngressos listaIngressos);
    
    //READ
    public ArrayList<ListaIngressos> readListaIngressos();
    public ListaIngressos readListaIngressosById(int id);
    
    //UPDATE
    public boolean updateListaIngressos(int id, ListaIngressos listaIngressos);
    
    //DELETE
    public boolean deleteListaIngressos(int id);
    public boolean deleteListaIngressos(ListaIngressos listaIngressos);
}
