package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class AtendenteDAOconcreto implements AtendenteDAO{

    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public AtendenteDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertAtendente(Funcionario atendente) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Atendente (nome, login, senha) VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, atendente.getNome());
            statement.setString(2, atendente.getLogin());
            statement.setString(3, atendente.getSenha());
            int r = statement.executeUpdate();
            if(r>0)
                resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList <Atendente> readAtendente() {
        ArrayList<Atendente> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Atendente";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                Atendente a = new Atendente(rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                lista.add(a);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Atendente readAtendenteById(int id) {
        Atendente a = null;
        try {
            String sql = "SELECT * FROM Atendente WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                a = new Atendente(rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return a;
    }
    
    @Override
    public Atendente readAtendenteByNome(String nome) {
        Atendente a = null;
        
            try {
                String sql = "SELECT * FROM Atendente WHERE nome =?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, nome);
                rs = statement.executeQuery();
                
                while (rs.next()) {
                a = new Atendente(rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                }
            } catch (SQLException sQLException) {
                System.out.println(sQLException.getMessage());
            }
            return a;
    }

    @Override
    public boolean updateAtendente(int id, Funcionario atendente) {
        boolean resultado = false;
        try {
            String sql = "UPDATE Atendente SET nome=?, login=?, senha=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, atendente.getNome());
            statement.setString(2, atendente.getLogin());
            statement.setString(3, atendente.getSenha());
            statement.setInt(4, id);
            int r = statement.executeUpdate();
            if(r > 0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteAtendente(int id) {
        boolean resultado = false;
        
        try {
            String sql = "DELETE FROM Atendente WHERE pk = ?";
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
    public boolean deleteAtendente(Funcionario atendente) {
        boolean resultado = false;
        
        try {
            String sql = "DELETE FROM Atendente WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}
