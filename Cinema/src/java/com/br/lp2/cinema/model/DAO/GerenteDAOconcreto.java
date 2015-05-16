package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class GerenteDAOconcreto implements GenericDAO {
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public GerenteDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object) {
        Gerente gerente = (Gerente)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Gerente (nome, login, senha) VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, gerente.getNome());
            statement.setString(2, gerente.getLogin());
            statement.setString(3, gerente.getSenha());
            int r = statement.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Gerente> read() {
        ArrayList<Gerente> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Gerente";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Gerente g = new Gerente(rs.getInt("pk"),rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                lista.add(g);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Gerente readById(int id) {
        Gerente g = null;
        try {
            String sql = "SELECT * FROM Gerente WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Gerente(rs.getInt("pk"),rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public Gerente readByNome(String nome) {
        Gerente g = null;
        try {
            String sql = "SELECT * FROM Gerente WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Gerente(rs.getInt("pk"),rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public boolean update(int id, Object object) {
        Gerente gerente = (Gerente)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE gerente SET nome=?, login=?, senha=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, gerente.getNome());
            statement.setString(2, gerente.getLogin());
            statement.setString(3, gerente.getSenha());
            statement.setInt(4, id);
            int r = statement.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean delete(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Gerente WHERE pk = ?";
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
            String sql = "DELETE FROM gerente WHERE nome = ?";
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