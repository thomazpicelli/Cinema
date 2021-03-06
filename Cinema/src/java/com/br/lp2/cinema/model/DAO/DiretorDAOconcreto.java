package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Diretor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class DiretorDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public DiretorDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object) {
        Diretor diretor = (Diretor)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO diretor(codigo,nome) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, diretor.getCodigo());
            statement.setString(2, diretor.getNome());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public ArrayList<Diretor> read(){
        ArrayList<Diretor> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM diretor";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Diretor d = new Diretor(rs.getInt("pk"), rs.getInt("codigo"), rs.getString("nome"));
                lista.add(d);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Diretor readById(int id) {
        Diretor d = null;
        try {
            String sql = "SELECT * FROM diretor WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                d = new Diretor(rs.getInt("pk"), rs.getInt("codigo"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return d;
    }

    @Override
    public Diretor readByNome(String nome) {
        Diretor d = null;
        try {
            String sql = "SELECT * FROM diretor WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                d = new Diretor(rs.getInt("pk"), rs.getInt("codigo"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return d;
    }

    @Override
    public boolean update(int id, Object object){
        Diretor diretor = (Diretor)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE diretor SET nome=? codigo WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, diretor.getNome());
            statement.setInt(2, diretor.getCodigo());
            statement.setInt(3, id);
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
            String sql = "DELETE FROM diretor WHERE id = ?";
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
            String sql = "DELETE FROM diretor WHERE nome =?";
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