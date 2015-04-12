package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Gerente;
import com.br.lp2.cinema.model.javabeans.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface GerenteDAO {
            
    //CREATE
    public boolean insertGerente(Funcionario gerente);
    
    //READ
    public ArrayList<Gerente> readGerente();
    public Gerente readGerenteById(int id);
    public Gerente readGerenteByNome(String nome);
    
    //UPDATE
    public boolean updateGerente(int id, Funcionario gerente);
    
    //DELETE
    public boolean deleteGerente(int id);
    public boolean deleteGerente(Funcionario gerente);    
}
