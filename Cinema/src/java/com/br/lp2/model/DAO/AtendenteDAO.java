package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Atendente;
import com.br.lp2.model.javabeans.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public interface AtendenteDAO {
        
    //CREATE
    public boolean insertAtendente(Funcionario atendente);
    
    //READ
    public ArrayList<Atendente> readAtendente();
    public Atendente readAtendenteById(int id);
    public Atendente readAtendenteByNome(String nome);
    
    //UPDATE
    public boolean updateAtendente(int id, Funcionario atendente);
    
    //DELETE
    public boolean deleteAtendente(int id);
    public boolean deleteAtendente(Funcionario atendente);    
}

