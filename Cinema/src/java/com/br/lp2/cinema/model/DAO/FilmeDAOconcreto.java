package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.connectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Diretor;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
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
            String sql = "INSERT INTO Filme (id_diretor, id_genero, id_listaAtores, id_distribuidora, nome, classificacao, ano, duracao, situacao, idioma) VALUES(?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, filme.getDiretor().getPk());
            statement.setObject(2, filme.getGenero().getPk());
            statement.setObject(3, filme.getListaAtores().getPk());
            statement.setObject(4, filme.getDistribuidora().getPk());
            statement.setString(5, filme.getNome());
            statement.setInt(6, filme.getClassificacao());
            statement.setInt(7, filme.getAno());
            statement.setInt(8, filme.getDuracao());
            statement.setObject(9, filme.getSituacao().toString());
            statement.setString(10, filme.getIdioma());
            int r = statement.executeUpdate();
            if(r>0)
                resultado = true;
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
                Filme f = new Filme(rs.getInt("pk"), new Diretor(rs.getInt("id_diretor")), new Genero(rs.getInt("id_genero")), new ListaAtores(rs.getInt("id_listaAtores")), new Distribuidora(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
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
                f = new Filme(rs.getInt("pk"), new Diretor(rs.getInt("id_diretor")), new Genero(rs.getInt("id_genero")), new ListaAtores(rs.getInt("id_listaAtores")), new Distribuidora(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));            
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
                f = new Filme(rs.getInt("pk"), new Diretor(rs.getInt("id_diretor")), new Genero(rs.getInt("id_genero")), new ListaAtores(rs.getInt("id_listaAtores")), new Distribuidora(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return f;
    }
    
    @Override
    public ArrayList<Filme> readFilmeByGenero(String genero) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN genero ON filme.id_genero = genero.pk WHERE genero.nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, genero);
            rs = statement.executeQuery();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), new Diretor(rs.getInt("id_diretor")), new Genero(rs.getInt("id_genero")), new ListaAtores(rs.getInt("id_listaAtores")), new Distribuidora(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    
    @Override
    public ArrayList<Filme> readFilmeByAtor(String ator) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN listaatores ON filme.id_listaatores = listaatores.pk JOIN infoator ON listaatores.id_infoator = infoator.pk JOIN ator ON infoator.id_ator = ator.pk WHERE ator.nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, ator);
            rs = statement.executeQuery();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), new Diretor(rs.getInt("id_diretor")), new Genero(rs.getInt("id_genero")), new ListaAtores(rs.getInt("id_listaAtores")), new Distribuidora(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), (Filme.tiposituacao)rs.getObject("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    
    @Override
    public ArrayList<Filme> readFilmeByDiretor(String diretor) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN diretor ON diretor.pk = filme.id_diretor WHERE diretor.nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, diretor);
            rs = statement.executeQuery();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), new Diretor(rs.getInt("id_diretor")), new Genero(rs.getInt("id_genero")), new ListaAtores(rs.getInt("id_listaAtores")), new Distribuidora(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), (Filme.tiposituacao)rs.getObject("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    

    @Override
    public boolean updateFilme(int id, Filme filme) {
         boolean resultado = false;
        try {
            String sql = "UPDATE filme SET id_diretor=?, id_genero=?, id_listaAtores=?, id_distribuidora=?, nome=?, classificacao=?, ano=?, duracao=?, situacao=?, idioma=? WHERE pk=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, filme.getDiretor().getPk());
            statement.setObject(2, filme.getGenero().getPk());
            statement.setObject(3, filme.getListaAtores().getPk());
            statement.setObject(4, filme.getDistribuidora().getPk());
            statement.setString(5, filme.getNome());
            statement.setInt(6, filme.getClassificacao());
            statement.setInt(7, filme.getAno());
            statement.setInt(8, filme.getDuracao());
            statement.setObject(9, filme.getSituacao().toString());
            statement.setString(10, filme.getIdioma());
            statement.setInt(11, id);
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