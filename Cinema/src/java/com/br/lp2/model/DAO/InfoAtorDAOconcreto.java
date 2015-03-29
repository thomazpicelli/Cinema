package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Ator;
import com.br.lp2.model.javabeans.InfoAtor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class InfoAtorDAOconcreto implements InfoAtorDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public InfoAtorDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertInfoAtor(InfoAtor infoAtor) {
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
    public ArrayList<InfoAtor> readInfoAtor() {
        ArrayList<InfoAtor> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM InfoAtor";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                InfoAtor ia = new InfoAtor((Ator)rs.getObject("id_ator"), rs.getString("papel"), rs.getString("part"));
                lista.add(ia);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public InfoAtor readInfoAtorById(int id) {
        InfoAtor ia = null;
        try {
            String sql = "SELECT * FROM InfoAtor WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                ia = new InfoAtor((Ator)rs.getObject("id_ator"), rs.getString("papel"), rs.getString("part"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return ia;
    }

    @Override
    public InfoAtor readInfoAtorByPapel(String papel) {
        InfoAtor ia = null;
        try {
            String sql = "SELECT * FROM InfoAtor WHERE papel=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, papel);
            rs = statement.executeQuery();
            while (rs.next()) {
                ia = new InfoAtor((Ator)rs.getObject("id_ator"), rs.getString("papel"), rs.getString("part"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return ia;
    }

    @Override
    public boolean updateInfoAtor(int id, InfoAtor infoAtor) {
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
    public boolean deleteInfoAtor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteInfoAtor(InfoAtor infoAtor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}