package com.br.lp2.cinema.model.DAO;

import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface GenericDAO {
    
    //CREATE
    public boolean insert(Object object);
    
    //READ
    public ArrayList<Object> read();
    public Object readById(int id);
    public Object readByNome(String nome);
    
    //UPDATE
    public boolean update(int id, Object object);
    
    //DELETE
    public boolean delete(int id);
    public boolean delete(String nome);    
}