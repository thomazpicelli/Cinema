package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Ingresso;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public interface IngressoDAO {
    
    //CREATE
    public boolean insertIngresso(Ingresso ingresso);
    
    //READ
    public ArrayList<Ingresso> readIngresso();
    public Ingresso readIngressoById(int id);
        
    //UPDATE
    public boolean updateIngresso(int id, Ingresso ingresso);
    
    //DELETE
    public boolean deleteIngresso(int id);
    public boolean deleteIngresso(Ingresso Ingresso);
}

