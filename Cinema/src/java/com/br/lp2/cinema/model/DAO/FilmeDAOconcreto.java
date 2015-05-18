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
public class FilmeDAOconcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public FilmeDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insert(Object object) {
        Filme filme = (Filme)object;
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
    public ArrayList<Filme> read() {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            GenericDAO diretor = new DiretorDAOconcreto();
            GenericDAO genero = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor)diretor.readById(rs.getInt("id_diretor")), (Genero)genero.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Filme readById(int id) {
        Filme f = null;
        try {
            String sql = "SELECT * FROM Filme WHERE pk =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            GenericDAO diretor = new DiretorDAOconcreto();
            GenericDAO genero = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                f = new Filme(rs.getInt("pk"), (Diretor)diretor.readById(rs.getInt("id_diretor")), (Genero)genero.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return f;
    }

    @Override
    public Filme readByNome(String nome) {
        Filme f = null;
        try {
            String sql = "SELECT * FROM Filme WHERE nome =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            rs = statement.executeQuery();
            GenericDAO diretor = new DiretorDAOconcreto();
            GenericDAO genero = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                f = new Filme(rs.getInt("pk"), (Diretor)diretor.readById(rs.getInt("id_diretor")), (Genero)genero.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return f;
    }
    
    public ArrayList<Filme> readFilmeByGenero(int pk) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN genero ON filme.id_genero = genero.pk WHERE genero.pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pk);
            rs = statement.executeQuery();
            GenericDAO diretor = new DiretorDAOconcreto();
            GenericDAO g = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor)diretor.readById(rs.getInt("id_diretor")), (Genero)g.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Filme> readFilmeByAtor(int pk) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN infoator ON filme.pk = infoator.id_filme JOIN ator ON infoator.id_ator = ator.pk WHERE ator.pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pk);
            rs = statement.executeQuery();
            GenericDAO diretor = new DiretorDAOconcreto();
            GenericDAO genero = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor)diretor.readById(rs.getInt("id_diretor")), (Genero)genero.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Filme> readFilmeByDiretor(int pk) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN diretor ON diretor.pk = filme.id_diretor WHERE diretor.pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pk);
            rs = statement.executeQuery();
            GenericDAO d = new DiretorDAOconcreto();
            GenericDAO g = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor)d.readById(rs.getInt("id_diretor")), (Genero)g.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Filme> readFilmeByDistribuidora(int pk) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM Filme INNER JOIN distribuidora ON distribuidora.pk = filme.id_distribuidora WHERE distribuidora.pk=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pk);
            rs = statement.executeQuery();
            GenericDAO d = new DiretorDAOconcreto();
            GenericDAO g = new GeneroDAOconcreto();
            GenericDAO infoator = new InfoAtorDAOconcreto();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor)d.readById(rs.getInt("id_diretor")), (Genero)g.readById(rs.getInt("id_genero")), new ListaAtores(infoator.read()), (Distribuidora)distribuidora.readById(rs.getInt("id_distribuidora")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), rs.getInt("duracao"), rs.getString("situacao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    
    }

    @Override
    public boolean update(int id, Object object) {
        Filme filme = (Filme)object; 
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
    public boolean delete(int id) {
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
    public boolean delete(String nome) {
            boolean resultado = false;
        try {
            String sql = "DELETE FROM Filme WHERE nome =?";
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