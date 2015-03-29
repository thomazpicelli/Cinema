package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Diretor;
import com.br.lp2.model.javabeans.Distribuidora;
import com.br.lp2.model.javabeans.Filme;
import com.br.lp2.model.javabeans.Genero;
import com.br.lp2.model.javabeans.ListaAtores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public class FilmeDAOconcreto implements FilmeDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public FilmeDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertFilme(Filme filme) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO Filme (pk, id_diretor, id_genero, id_listaAtores, id_distribuidora, nome, classificacao, ano, duracao, situacao, idioma) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, filme.getPk());
            statement.setObject(2, filme.getDiretor());
            statement.setObject(3, filme.getGenero());
            statement.setObject(4, filme.getListaAtores());
            statement.setObject(5, filme.getDistribuidora());
            statement.setString(6, filme.getNome());
            statement.setInt(7, filme.getClassificacao());
            statement.setInt(8, filme.getAno());
            statement.setInt(9, filme.getDuracao());
            statement.setObject(10, filme.getSituacao());
            statement.setString(11, filme.getIdioma());
            rs = statement.executeQuery();
            resultado = statement.execute();
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Filme> readFilme() {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor)rs.getObject("id_diretor"), (Genero)rs.getObject("id_genero"), (ListaAtores)rs.getObject("id_listaAtores"), (Distribuidora)rs.getObject("id_distribuidora"), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), (Filme.tiposituacao)rs.getObject("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Filme readFilmeById(int id) {
        Filme f = null;
        try {
            String sql = "SELECT * FROM Filme WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                f = new Filme(rs.getInt("pk"), (Diretor)rs.getObject("id_diretor"), (Genero)rs.getObject("id_genero"), (ListaAtores)rs.getObject("id_listaAtores"), (Distribuidora)rs.getObject("id_distribuidora"), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), (Filme.tiposituacao)rs.getObject("situacao"), rs.getString("idioma"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return f;
    }

    @Override
    public Filme readFilmeByNome(String nome) {
        Filme f = null;
        try {
            String sql = "SELECT * FROM Filme WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            while (rs.next()) {
                f = new Filme(rs.getInt("pk"), (Diretor)rs.getObject("id_diretor"), (Genero)rs.getObject("id_genero"), (ListaAtores)rs.getObject("id_listaAtores"), (Distribuidora)rs.getObject("id_distribuidora"), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), (Filme.tiposituacao)rs.getObject("situacao"), rs.getString("idioma"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return f;
    }

    @Override
    public boolean updateFilme(int id, Filme filme) {
         boolean resultado = false;
        try {
            String sql = "UPDATE filme SET pk=? id_diretor=? id_genero=? id_listaAtores=? id_distribuidora=? nome=? classificacao=? ano=? duracao=? situacao=? idioma=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, filme.getPk());
            statement.setObject(2, filme.getDiretor());
            statement.setObject(3, filme.getGenero());
            statement.setObject(4, filme.getListaAtores());
            statement.setObject(5, filme.getDistribuidora());
            statement.setString(6, filme.getNome());
            statement.setInt(7, filme.getClassificacao());
            statement.setInt(8, filme.getAno());
            statement.setInt(9, filme.getDuracao());
            statement.setObject(10, filme.getSituacao());
            statement.setString(11, filme.getIdioma());
            int r = statement.executeUpdate();
            resultado = r>0;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteFilme(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM Filme WHERE pk = ?";
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
    public boolean deleteFilme(Filme filme) {
            boolean resultado = false;
        try {
            String sql = "DELETE FROM Filme WHERE VALUES(?)";
            statement = connection.prepareStatement(sql);
            int r = statement.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
    
}