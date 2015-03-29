package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class GeneroDAOconcreto implements GeneroDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public GeneroDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertGenero(Genero genero) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO genero(nome) VALUES(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, genero.getNome());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Genero> readGenero() {
        ArrayList<Genero> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM genero";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Genero c = new Genero(rs.getInt("id"), rs.getString("nome"));
                lista.add(c);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Genero readGeneroById(int pk) {
        Genero g =null;
        try {
            String sql = "SELECT * FROM genero WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pk);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Genero(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public Genero readGeneroByNome(String nome) {
        Genero g =null;
        try {
            String sql = "SELECT * FROM genero WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Genero(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public boolean updateGenero(int id, Genero genero) {
        boolean resultado = false;
        try {
            String sql = "UPDATE genero SET nome=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, genero.getNome());
            statement.setInt(2, id);
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteGenero(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM genero WHERE id = ?";
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
    public boolean deleteGenero(Genero genero) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM genero WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}