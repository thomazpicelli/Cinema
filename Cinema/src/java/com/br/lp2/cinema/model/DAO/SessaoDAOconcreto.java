package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngressos;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
            String sql = "INSERT INTO Sessao (id_filme, id-sala, horario, legendado, id_listaIngressos) VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sessao.getFilme().getPk());
            statement.setObject(2, sessao.getSala().getPk());
            statement.setTime(3, (Time)sessao.getHorario());
            statement.setBoolean(4, sessao.isLegendado());
            statement.setObject(5, sessao.getLista().getPk());
            int r = statement.executeUpdate();
            if(r>0)
                resultado = true;
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
            FilmeDAO filme = new FilmeDAOconcreto();
            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("pk"), filme.readFilmeById(rs.getInt("pk")), new Sala(rs.getInt("id_sala")), rs.getBoolean("legendado"), new ListaIngressos(rs.getInt("id_listaIngressos")));
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
                s = new Sessao(rs.getInt("pk"), (Filme)rs.getObject("id_filme"), (Sala)rs.getObject("id_sala"), (Date)rs.getDate("horario"), rs.getBoolean("legendado"), (ListaIngressos)rs.getObject("id_listaIngressos"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public Sessao readSessaoBySala(int id) {
        Sessao s = null;
        try {
            String sql = "SELECT * FROM Sessao WHERE id_sala=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                s = new Sessao(rs.getInt("pk"), (Filme)rs.getObject("id_filme"), (Sala)rs.getObject("id_sala"), (Date)rs.getDate("horario"), rs.getBoolean("legendado"), (ListaIngressos)rs.getObject("id_listaIngressos"));
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
            String sql = "UPDATE sessao SET id_filme=?, id_sala=?, horario=?, legendado=?, id_listaIngressos=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sessao.getFilme().getPk());
            statement.setObject(2, sessao.getSala().getPk());
            statement.setTime(3, (Time)sessao.getHorario());
            statement.setBoolean(4, sessao.isLegendado());
            statement.setObject(5, sessao.getLista().getPk()); 
            statement.setInt(6, id);
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
