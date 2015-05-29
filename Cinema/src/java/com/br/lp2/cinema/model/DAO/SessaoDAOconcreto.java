package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngressos;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author thomazpicelli
 */
public class SessaoDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public SessaoDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insert(Object object) {
        Sessao sessao = (Sessao)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Sessao (id_filme, id_sala, horario, legendado) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sessao.getFilme().getPk());
            statement.setInt(2, sessao.getSala().getPk());
            statement.setString(3, sessao.getHorario());
            statement.setBoolean(4, sessao.isLegendado());
            int r = statement.executeUpdate();
            if(r>0)
                resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Sessao> read() {
        ArrayList<Sessao> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Sessao";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            GenericDAO filme = new FilmeDAOconcreto();
            GenericDAO sala = new SalaDAOconcreto();
            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("pk"), (Filme)filme.readById(rs.getInt("id_filme")), (Sala)sala.readById(rs.getInt("id_sala")), rs.getString("horario"), rs.getBoolean("legendado"), new ListaIngressos(rs.getInt("id_listaIngressos")));
                lista.add(s);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Sessao readById(int id) {
        Sessao s = null;
        try {
            String sql = "SELECT * FROM Sessao WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            GenericDAO filme = new FilmeDAOconcreto();
            GenericDAO sala = new SalaDAOconcreto();
            while (rs.next()) {
                s = new Sessao(rs.getInt("pk"), (Filme)filme.readById(rs.getInt("id_filme")), (Sala)sala.readById(rs.getInt("id_sala")), rs.getString("horario"), rs.getBoolean("legendado"), new ListaIngressos(rs.getInt("id_listaIngressos")));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return s;
    }

    @Override
    public Sessao readByNome(String nome) {
        return null;
    }
    
    public ArrayList readByHorario(String sessao){
        ArrayList<Sessao> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Sessao WHERE SUBSTR(horario,1,2)=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, sessao);
            rs = statement.executeQuery();
            GenericDAO filme = new FilmeDAOconcreto();
            GenericDAO sala = new SalaDAOconcreto();
            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("pk"), (Filme)filme.readById(rs.getInt("id_filme")), (Sala)sala.readById(rs.getInt("id_sala")), rs.getString("horario"), rs.getBoolean("legendado"), new ListaIngressos(rs.getInt("id_listaIngressos")));
                lista.add(s);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    
    public ArrayList readByFilme(int f) {
        ArrayList<Sessao> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Sessao INNER JOIN Filme ON filme.pk = sessao.id_filme WHERE id_filme=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, f);
            rs = statement.executeQuery();
            GenericDAO filme = new FilmeDAOconcreto();
            GenericDAO sala = new SalaDAOconcreto();
            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("pk"), (Filme)filme.readById(rs.getInt("id_filme")), (Sala)sala.readById(rs.getInt("id_sala")), rs.getString("horario"), rs.getBoolean("legendado"), new ListaIngressos(rs.getInt("id_listaIngressos")));
                lista.add(s);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public boolean update(int id, Object object) {
        Sessao sessao = (Sessao)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE sessao SET id_filme=?, id_sala=?, horario=?, legendado=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sessao.getFilme().getPk());
            statement.setInt(2, sessao.getSala().getPk());
            statement.setString(3, sessao.getHorario());
            statement.setBoolean(4, sessao.isLegendado());
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
    public boolean delete(String nome) {
        return false;
    }
}