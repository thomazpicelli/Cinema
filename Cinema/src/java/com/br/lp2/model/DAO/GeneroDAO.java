package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Genero;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface GeneroDAO {
    //CRUD DE GENERO
    //CREATE
    public boolean insertGenero(Genero genero);
    
    //READ
    public ArrayList<Genero> readGenero();
    public Genero readGeneroById(int id);
    public Genero readGeneroByNome(String nome);
    
    //UPDATE
    public boolean updateGenero(int id, Genero genero);
    
    //DELETE
    public boolean deleteGenero(int id);
    public boolean deleteGenero(Genero genero);
}
