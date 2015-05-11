package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Sala;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface SalaDAO {
                
    //CREATE
    public boolean insertSala(Sala sala);
    
    //READ
    public ArrayList<Sala> readSala();
    public Sala readSalaById(int id);
    public Sala readSalaByNumero(int numero);
    
    //UPDATE
    public boolean updateSala(int id, Sala sala);
    
    //DELETE
    public boolean deleteSala(int id);
}
