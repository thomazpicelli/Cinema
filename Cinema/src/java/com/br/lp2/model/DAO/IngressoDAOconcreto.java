package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Cliente.Especiais;
import com.br.lp2.model.javabeans.Ingresso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class IngressoDAOconcreto implements IngressoDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public IngressoDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertIngresso(Ingresso ingresso) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Ingresso (pk, id, inteira, tipo) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ingresso.getPk());
            statement.setInt(2, ingresso.getId());
            statement.setBoolean(3, ingresso.isInteira());
            statement.setObject(4,(Especiais)ingresso.getTipo());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Ingresso> readIngresso() {
        ArrayList<Ingresso> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Ingresso";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Ingresso i = new Ingresso(rs.getInt("pk"), rs.getInt("id"), rs.getBoolean("inteira"), (Especiais)rs.getObject("tipo"));
                lista.add(i);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Ingresso readIngressoById(int id) {
        Ingresso i = null;
        try {
            String sql = "SELECT * FROM Ingresso WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                i = new Ingresso(rs.getInt("pk"), rs.getInt("id"), rs.getBoolean("inteira"), (Especiais)rs.getObject("tipo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return i;
    }

    @Override
    public boolean updateIngresso(int id, Ingresso ingresso) {
        boolean resultado = false;
        try {
            String sql = "UPDATE Ingresso SET pk=? id=? inteira=? tipo=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ingresso.getPk());
            statement.setInt(2, ingresso.getId());
            statement.setBoolean(3, ingresso.isInteira());
            statement.setObject(4,(Especiais)ingresso.getTipo());
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteIngresso(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Ingresso WHERE pk = ?";
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
    public boolean deleteIngresso(Ingresso Ingresso) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Ingresso WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }   
}
