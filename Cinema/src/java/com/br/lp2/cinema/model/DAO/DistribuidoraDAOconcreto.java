package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class DistribuidoraDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  

    public DistribuidoraDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object){
        Distribuidora distribuidora = (Distribuidora)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO distribuidora(nome) VALUES(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, distribuidora.getNome());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Distribuidora> read() {
        ArrayList<Distribuidora> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM distribuidora";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Distribuidora d = new Distribuidora(rs.getInt("pk"), rs.getString("nome"));
                lista.add(d);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Distribuidora readById(int id) {
        Distribuidora d = null;
        try {
            String sql = "SELECT * FROM distribuidora WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                d = new Distribuidora(rs.getInt("pk"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return d;
    }

    @Override
    public Distribuidora readByNome(String nome) {
        Distribuidora d = null;
        try {
            String sql = "SELECT * FROM distribuidora WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                d = new Distribuidora(rs.getInt("pk"), rs.getString("nome"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return d;
    }

    @Override
    public boolean update(int id, Object object) {
        Distribuidora distribuidora = (Distribuidora)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE distribuidora SET nome=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, distribuidora.getNome());
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
            String sql = "DELETE FROM distribuidora WHERE id = ?";
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
            String sql = "DELETE FROM distribuidora WHERE nome = ?";
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