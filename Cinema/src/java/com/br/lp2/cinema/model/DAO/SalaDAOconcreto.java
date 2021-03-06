package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class SalaDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public SalaDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }    

    @Override
    public boolean insert(Object object) {
        Sala sala = (Sala)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Sala (numero, lotacao, especial, situacao) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sala.getNumero());
            statement.setInt(2, sala.getLotacao());
            statement.setInt(3, sala.getEspecial());
            statement.setObject(4, sala.getSituacao().toString());
            int r = statement.executeUpdate();
            if(r>0)
                resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Sala> read() {
        ArrayList<Sala> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Sala";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Sala s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"), rs.getString("situacao"));
                lista.add(s);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Sala readById(int id) {
        Sala s = null;
        try {
            String sql = "SELECT * FROM Sala WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"), rs.getString("situacao"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public Sala readByNome(String nome) {
        int numero = Integer.parseInt(nome);
        Sala s = null;
        try {
            String sql = "SELECT * FROM Sala WHERE numero =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, numero);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"),rs.getString("situacao"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    public Sala readByNumero(int numero) {
        Sala s = null;
        try {
            String sql = "SELECT * FROM Sala WHERE numero =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, numero);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sala(rs.getInt("pk"), rs.getInt("numero"), rs.getInt("lotacao"), rs.getInt("especial"),rs.getString("situacao"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public boolean update(int id, Object object) {
        Sala sala = (Sala)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE sala SET numero=?, lotacao=?, especial=?, situacao=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sala.getNumero());
            statement.setInt(2, sala.getLotacao());
            statement.setInt(3, sala.getEspecial());
            statement.setObject(4, sala.getSituacao().toString());
            statement.setInt(5, id);
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
    public boolean delete(String nome) {
        int numero = Integer.parseInt(nome);
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Sala WHERE numero = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, numero); 
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}