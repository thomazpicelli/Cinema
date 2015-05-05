package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Filme;
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
    public ArrayList<Filme> readFilmeByGenero(String genero); 
    public ArrayList<Filme> readFilmeByAtor(String ator);
    public ArrayList<Filme> readFilmeByDiretor(String diretor);

    //UPDATE
    public boolean updateFilme(int id, Filme filme);
    
    //DELETE
    public boolean deleteFilme(int id);
    public boolean deleteFilme(Filme filme);    

}
