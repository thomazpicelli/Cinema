package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.ListaAtores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class ListaAtoresDAOconcreto implements ListaAtoresDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public ListaAtoresDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertListaAtores(ListaAtores listaAtores) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO ListaAtores (id_infoator) VALUES(?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(2, listaAtores.getLista());
            int r = statement.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<ListaAtores> readListaAtores() {
        ArrayList<ListaAtores> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM ListaAtores";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                ListaAtores la = new ListaAtores(rs.getInt("pk"));
                lista.add(la);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public ListaAtores readListaAtoresById(int id) {
        ListaAtores la = null;
        try {
            String sql = "SELECT * FROM ListaAtores WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                la = new ListaAtores(rs.getInt("pk"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return la;
    }

    @Override
    public boolean updateListaAtores(int id, ListaAtores listaAtores) {
        boolean resultado = false;
        try {
            String sql = "UPDATE ListaAtores SET pk=? id_infoator=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, listaAtores.getPk());
            statement.setObject(2, listaAtores.getLista());
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteListaAtores(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM ListaAtores WHERE pk = ?";
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
    public boolean deleteListaAtores(ListaAtores listaAtores) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM ListaAtores WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
    
}
