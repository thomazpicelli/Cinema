package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Cliente;
import com.br.lp2.model.javabeans.Cliente.Especiais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class ClienteDAOconcreto implements ClienteDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public ClienteDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertCliente(Cliente cliente) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO cliente(nome,anonasc,tipo) VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getAnoNasc());
            statement.setObject(3,(Especiais)cliente.getTipo());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Cliente> readCliente() {
        ArrayList<Cliente> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM cliente";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anonasc"), (Especiais)rs.getObject("tipo"));
                lista.add(c);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente readClienteById(int id) {
        Cliente c = null;
        try {
            String sql = "SELECT * FROM clinte WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                c = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anonasc"), (Especiais)rs.getObject("tipo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return c;
    }

    @Override
    public Cliente readClienteByNome(String nome) {
        Cliente c = null;
        try {
            String sql = "SELECT * FROM cliente WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                c = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anonasc"), (Especiais)rs.getObject("tipo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return c;
    }

    @Override
    public boolean updateCliente(int id, Cliente cliente) {
        boolean resultado = false;
        try {
            String sql = "UPDATE cliente SET nome=? datanasc=? tipo=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getAnoNasc());
            statement.setObject(3,(Especiais) cliente.getTipo());
            statement.setInt(4, id);
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteCliente(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM cliente WHERE id = ?";
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
    public boolean deleteCliente(Cliente cliente) {
       boolean resultado = false;
        try {
            String sql = "DELETE FROM cliente WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}
