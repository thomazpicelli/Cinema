package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Distribuidora;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface DistribuidoraDAO {
    //CRUD DE GENERO
    //CREATE
    public boolean insertDistribuidora(Distribuidora distribuidora);
    
    //READ
    public ArrayList<Distribuidora> readDistristribuidora();
    public Distribuidora readDistribuidoraById(int id);
    public Distribuidora readDistribuidoraByNome(String nome);
    
    //UPDATE
    public boolean updateDistribuidora(int id, Distribuidora distribuidora);
    
    //DELETE
    public boolean deleteDistribuidora(int id);
    public boolean deleteDistribuidora(Distribuidora distribuidora);
}