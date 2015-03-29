package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Cliente;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface ClienteDAO {
    //CRUD DE CLIENTE
    //CREATE
    public boolean insertCliente(Cliente cliente);
    
    //READ
    public ArrayList<Cliente> readCliente();
    public Cliente readClienteById(int id);
    public Cliente readClienteByNome(String nome);
    
    //UPDATE
    public boolean updateCliente(int id, Cliente cliente);
    
    //DELETE
    public boolean deleteCliente(int id);
    public boolean deleteCliente(Cliente cliente);
}