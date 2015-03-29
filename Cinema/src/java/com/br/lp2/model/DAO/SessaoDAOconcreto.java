package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Filme;
import com.br.lp2.model.javabeans.ListaIngressos;
import com.br.lp2.model.javabeans.Sala;
import com.br.lp2.model.javabeans.Sessao;
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
public class SessaoDAOconcreto implements SessaoDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public SessaoDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertSessao(Sessao sessao) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Sessao (pk, id_filme, id-sala, horario, legendado, id_listIngresso) VALUES(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sessao.getPk());
            statement.setObject(2, sessao.getFilme());
            statement.setObject(3, sessao.getSala());
            statement.setDate(4, (Date)sessao.getHorario());
            statement.setBoolean(5, sessao.isLegendado());
            statement.setObject(6, sessao.getLista());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Sessao> readSessao() {
        ArrayList<Sessao> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Sessao";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("pk"), (Filme)rs.getObject("id_filme"), (Sala)rs.getObject("id_sala"), (Date)rs.getDate("horario"), rs.getBoolean("legendado"), (ListaIngressos)rs.getObject("id_listaIngresso"));
                lista.add(s);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Sessao readSessaoById(int id) {
        Sessao s = null;
        try {
            String sql = "SELECT * FROM Sessao WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sessao(rs.getInt("pk"), (Filme)rs.getObject("id_filme"), (Sala)rs.getObject("id_sala"), (Date)rs.getDate("horario"), rs.getBoolean("legendado"), (ListaIngressos)rs.getObject("id_listaIngresso"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public Sessao readSessaoBySala(Sala sala) {
        Sessao s = null;
        try {
            String sql = "SELECT * FROM Sessao WHERE sala =?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sala);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sessao(rs.getInt("pk"), (Filme)rs.getObject("id_filme"), (Sala)rs.getObject("id_sala"), (Date)rs.getDate("horario"), rs.getBoolean("legendado"), (ListaIngressos)rs.getObject("id_listaIngresso"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public boolean updateSessao(int id, Sessao sessao) {
        boolean resultado = false;
        try {
            String sql = "UPDATE sessao SET pk=? id_filme=? id_sala=? horario=?, legendado=?, id_listaIngresso=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sessao.getPk());
            statement.setObject(2, sessao.getFilme());
            statement.setObject(3, sessao.getSala());
            statement.setDate(4, (Date)sessao.getHorario());
            statement.setBoolean(5, sessao.isLegendado());
            statement.setObject(6, sessao.getLista()); 
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteSessao(int id) {
       boolean resultado = false;
        try {
            String sql = "DELETE FROM Sessao WHERE pk = ?";
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
    public boolean deleteSessao(Sala sala) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Sessao WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
    
}
