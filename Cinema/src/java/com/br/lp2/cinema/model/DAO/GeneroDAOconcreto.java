package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class GeneroDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public GeneroDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object) {
        Genero genero = (Genero)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO genero(nome) VALUES(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, genero.getNome());
            int r = statement.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Genero> read() {
        ArrayList<Genero> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM genero";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Genero c = new Genero(rs.getInt("pk"), rs.getString("nome"));
                lista.add(c);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Genero readById(int pk) {
        Genero g =null;
        try {
            String sql = "SELECT * FROM genero WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pk);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Genero(rs.getInt("pk"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public Genero readByNome(String nome) {
        Genero g =null;
        try {
            String sql = "SELECT * FROM genero WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Genero(rs.getInt("pk"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public boolean update(int id, Object object){
        Genero genero = (Genero) object;
        boolean resultado = false;
        try {
            String sql = "UPDATE genero SET nome=? WHERE pk=?";
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
    public boolean delete(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM genero WHERE pk = ?";
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
            String sql = "DELETE FROM genero WHERE nome =?";
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