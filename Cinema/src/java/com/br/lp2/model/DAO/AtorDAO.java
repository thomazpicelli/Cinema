package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Ator;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface AtorDAO {
    //CRUD DE ATOR
    //CREATE
    public boolean insertAtor(Ator ator);
    
    //READ
    public ArrayList<Ator> readAtor();
    public Ator readAtorById(int id);
    public Ator readAtorByNome(String nome);
    
    //UPDATE
    public boolean updateAtor(int id, Ator ator);
    
    //DELETE
    public boolean deleteAtor(int id);
    public boolean deleteAtor(Ator ator);    
}
