package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Ator;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class AtorDAOconcreto implements AtorDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public AtorDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertAtor(Ator ator) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO ator(nome,nacionalidade,datanasc) VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, ator.getNome());
            statement.setString(2, ator.getNacionalidade());
            statement.setDate(3, (Date)ator.getDatanasc());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Ator> readAtor() {
        ArrayList<Ator> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM ator";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Ator a = new Ator(rs.getInt("pk"), rs.getString("nome"), rs.getString("nacionalidade"), rs.getDate("datanasc"));
                lista.add(a);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Ator readAtorById(int id) {
        Ator a =null;
        try {
            String sql = "SELECT * FROM ator WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                a = new Ator(rs.getInt("pk"), rs.getString("nome"), rs.getString("nacionalidade"), rs.getDate("datanasc"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return a;
    }

    @Override
    public Ator readAtorByNome(String nome) {
        Ator a = null;
        try {
            String sql = "SELECT * FROM ator WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                a = new Ator(rs.getInt("pk"), rs.getString("nome"), rs.getString("nacionalidade"), rs.getDate("datanasc"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return a;
    }

    @Override
    public boolean updateAtor(int id, Ator ator) {
        boolean resultado = false;
        try {
            String sql = "UPDATE ator SET nome=? nacionalidade=? datanasc=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, ator.getNome());
            statement.setString(2, ator.getNacionalidade());
            statement.setDate(3, (Date)ator.getDatanasc());
            statement.setInt(4, id);
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteAtor(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM ator WHERE id = ?";
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
    public boolean deleteAtor(Ator ator) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM ator WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
    
}