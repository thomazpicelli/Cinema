package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Filme;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface FilmeDAO {
                
    //CREATE
    public boolean insertFilme(Filme filme);
    
    //READ
    public ArrayList<Filme> readFilme();
    public Filme readFilmeById(int id);
    public Filme readFilmeByNome(String nome);
    
    //UPDATE
    public boolean updateFilme(int id, Filme filme);
    
    //DELETE
    public boolean deleteFilme(int id);
    public boolean deleteFilme(Filme filme);    
}
