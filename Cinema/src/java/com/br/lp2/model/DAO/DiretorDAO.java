package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Diretor;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface DiretorDAO {
    //CRUD DE DIRETOR
    //CREATE
    public boolean insertDiretor(Diretor diretor);
    
    //READ
    public ArrayList<Diretor> readDiretor();
    public Diretor readDiretorById(int id);
    public Diretor readDiretorByNome(String nome);
    
    //UPDATE
    public boolean updateDiretor(int id, Diretor diretor);
    
    //DELETE
    public boolean deleteDiretor(int id);
    public boolean deleteDiretor(Diretor diretor);    
}

