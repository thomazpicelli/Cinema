package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.ListaIngressos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class ListaIngressosDAOconcreto implements ListaIngressosDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public ListaIngressosDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertListaIngressos(ListaIngressos listaIngressos) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO ListaIngressos (pk, id_ingresso) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, listaIngressos.getPk());
            statement.setObject(2, listaIngressos.getLista());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<ListaIngressos> readListaIngressos() {
        ArrayList<ListaIngressos> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM ListaIngressos";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                ListaIngressos li = new ListaIngressos();
                lista.add(li);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public ListaIngressos readListaIngressosById(int id) {
        ListaIngressos li = null;
        try {
            String sql = "SELECT * FROM ListaIngressos WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                li = new ListaIngressos();
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return li;
    }

    @Override
    public boolean updateListaIngressos(int id, ListaIngressos listaIngressos) {
        boolean resultado = false;
        try {
            String sql = "UPDATE ListaIngressos SET pk=? id_ingresso=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, listaIngressos.getPk());
            statement.setObject(2, listaIngressos.getLista());
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteListaIngressos(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM ListaIngressos WHERE pk = ?";
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
    public boolean deleteListaIngressos(ListaIngressos listaIngressos) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM ListaIngressos WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}
