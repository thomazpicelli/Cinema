package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface FuncionarioDAO {
    //CRUD DE FUNCIONARIO
    //CREATE
    public boolean insertFuncionario(Funcionario funcionario, boolean tipo);
    
    //READ
    public ArrayList<Funcionario> readFuncionario();
    public Funcionario readFuncionarioById(int id);
    public Funcionario readFuncionarioByNome(String nome);
    
    //UPDATE
    public boolean updateFuncionario(int id, Funcionario funcionario);
    
    //DELETE
    public boolean deleteFuncionario(int id);
    public boolean deleteFuncionario(Funcionario funcionario);
}
