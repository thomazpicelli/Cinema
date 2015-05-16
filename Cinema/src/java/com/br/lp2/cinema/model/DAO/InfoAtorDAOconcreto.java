package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Ator;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.InfoAtor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class InfoAtorDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public InfoAtorDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object) {
        InfoAtor infoAtor = (InfoAtor)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Gerente (id_ator, papel, part) VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, infoAtor.getAtor());
            statement.setString(2, infoAtor.getPapel());
            statement.setString(3, infoAtor.getPart());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<InfoAtor> read() {
        ArrayList<InfoAtor> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM InfoAtor";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                InfoAtor ia = new InfoAtor( new Ator(rs.getInt("id_ator")), new Filme(rs.getInt("id_filme")), rs.getString("papel"), rs.getString("part"));
                lista.add(ia);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public InfoAtor readById(int id) {
        InfoAtor ia = null;
        try {
            String sql = "SELECT * FROM InfoAtor WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                ia = new InfoAtor( new Ator(rs.getInt("id_ator")), new Filme(rs.getInt("id_filme")), rs.getString("papel"), rs.getString("part"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return ia;
    }
    
    public ArrayList<InfoAtor> readByFilme(int id) {
        ArrayList<InfoAtor> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM InfoAtor WHERE id_filme =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                InfoAtor ia = new InfoAtor( new Ator(rs.getInt("id_ator")), new Filme(rs.getInt("id_filme")), rs.getString("papel"), rs.getString("part"));
                lista.add(ia);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public InfoAtor readByNome(String nome) {
        InfoAtor ia = null;
        try {
            String sql = "SELECT * FROM InfoAtor WHERE papel=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                ia = new InfoAtor( new Ator(rs.getInt("id_ator")), new Filme(rs.getInt("id_filme")), rs.getString("papel"), rs.getString("part"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return ia;
    }

    @Override
    public boolean update(int id, Object object) {
        InfoAtor infoAtor = (InfoAtor) object;
        boolean resultado = false;
        try {
            String sql = "UPDATE infoAtor SET id_ator=? papel=? part=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, infoAtor.getAtor());
            statement.setString(2, infoAtor.getPapel());
            statement.setString(3, infoAtor.getPart());
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
            String sql = "DELETE FROM Infoator WHERE pk = ?";
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
            String sql = "DELETE FROM Infoator WHERE papel = ?";
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