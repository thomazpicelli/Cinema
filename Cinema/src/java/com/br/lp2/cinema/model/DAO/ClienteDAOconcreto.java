package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Cliente;
import com.br.lp2.cinema.model.javabeans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class ClienteDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public ClienteDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object){
        Cliente cliente = (Cliente)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Cliente (nome, anoNasc, tipo) VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getAnoNasc());
            statement.setString(3, cliente.getTipo().toString());
            int r = statement.executeUpdate();
            if(r>0)
                resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Cliente> read(){
        ArrayList<Cliente> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Cliente";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                Cliente a = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anoNasc"), rs.getString("tipo"));
                lista.add(a);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente readById(int id) {
        Cliente a = null;
        try {
            String sql = "SELECT * FROM Cliente WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                a = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anoNasc"), rs.getString("tipo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return a;
    }
    
    @Override
    public Cliente readByNome(String nome) {
        Cliente a = null;
        try {
            String sql = "SELECT * FROM Cliente WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
                
            while (rs.next()) {
                a = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anoNasc"), rs.getString("tipo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return a;
    }

    @Override
    public boolean update(int id, Object object){
        Cliente cliente = (Cliente)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE Cliente SET nome=?, anoNasc=?, tipo=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getAnoNasc());
            statement.setString(3, cliente.getTipo().toString());
            statement.setInt(4, id);
            int r = statement.executeUpdate();
            if(r > 0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }
    
    @Override
    public boolean delete(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Cliente WHERE pk = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id); 
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean delete(String nome) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Cliente WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}
