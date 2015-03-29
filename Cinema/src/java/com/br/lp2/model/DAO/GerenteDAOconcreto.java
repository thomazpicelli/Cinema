package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Funcionario;
import com.br.lp2.model.javabeans.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class GerenteDAOconcreto implements GerenteDAO {
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public GerenteDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertGerente(Funcionario gerente) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Gerente (pk, nome, login, senha) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, gerente.getPk());
            statement.setString(2, gerente.getNome());
            statement.setString(3, gerente.getLogin());
            statement.setString(4, gerente.getSenha());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Gerente> readGerente() {
        ArrayList<Gerente> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Gerente";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Gerente a = new Gerente(rs.getInt("pk"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                lista.add(a);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Gerente readGerenteById(int id) {
        Gerente g = null;
        try {
            String sql = "SELECT * FROM Gerente WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Gerente(rs.getInt("pk"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public Gerente readGerenteByNome(String nome) {
        Gerente g = null;
        try {
            String sql = "SELECT * FROM Gerente WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                g = new Gerente(rs.getInt("pk"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public boolean updateGerente(int id, Funcionario gerente) {
        boolean resultado = false;
        try {
            String sql = "UPDATE gerente SET pk=? nome=? login=? senha=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, gerente.getPk());
            statement.setString(2, gerente.getNome());
            statement.setString(3, gerente.getLogin());
            statement.setString(4, gerente.getSenha());
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteGerente(int id) {
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
    public boolean deleteGerente(Funcionario gerente) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM gerente WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
    
}