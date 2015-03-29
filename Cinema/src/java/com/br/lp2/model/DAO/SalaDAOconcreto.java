package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class SalaDAOconcreto implements SalaDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public SalaDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }    

    @Override
    public boolean insertSala(Sala sala) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Sala (pk, numero, lotacao, especial, situacao) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sala.getPk());
            statement.setInt(2, sala.getNumero());
            statement.setInt(3, sala.getLotacao());
            statement.setObject(4, sala.getSituacao());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Sala> readGerente() {
        ArrayList<Sala> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Sala";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Sala s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"), (Sala.Situacao)rs.getObject("situacao"));
                lista.add(s);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Sala readSalaById(int id) {
        Sala s = null;
        try {
            String sql = "SELECT * FROM Sala WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"), (Sala.Situacao)rs.getObject("situacao"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public Sala readSalaByNumero(int numero) {
        Sala s = null;
        try {
            String sql = "SELECT * FROM Sala WHERE numero =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, numero);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"), (Sala.Situacao)rs.getObject("situacao"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public boolean updateSala(int id, Sala sala) {
        boolean resultado = false;
        try {
            String sql = "UPDATE sala SET pk=? numero=? lotacao=? especial=? situacao=?";
            statement = connection.prepareStatement(sql);
             statement = connection.prepareStatement(sql);
            statement.setInt(1, sala.getPk());
            statement.setInt(2, sala.getNumero());
            statement.setInt(3, sala.getLotacao());
            statement.setObject(4, sala.getSituacao());
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteSala(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Sala WHERE pk = ?";
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
    public boolean deleteSala(Sala sala) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM sala WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}
