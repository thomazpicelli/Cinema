package com.br.lp2.model.DAO;

import com.br.lp2.model.connectionFactory.ConnectionFactory;
import com.br.lp2.model.javabeans.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomazpicelli
 */
public class FuncionarioDAOconcreto implements FuncionarioDAO{
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet rs;  
    
    public FuncionarioDAOconcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertFuncionario(Funcionario funcionario, boolean tipo) {
        boolean resultado = false;
        try {
            
            String sql = "SELECT pk FROM funcionario WHERE funcionario.login=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, funcionario.getLogin());
            ResultSet resultset = statement.executeQuery();
            
            if(resultset!=null && !resultset.next()){
                
                sql = "INSERT INTO funcionario(nome,login,senha) VALUES(?,?,?)";
                statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, funcionario.getNome());
                statement.setString(2, funcionario.getLogin());
                statement.setString(3, funcionario.getSenha());
                resultado = statement.execute();

                long key = -1;
                ResultSet resultSet = statement.getGeneratedKeys();
                while(resultSet!=null && resultSet.next()){
                    key = resultSet.getLong(1);
                }
                if(tipo){    
                    sql = "INSERT INTO gerente(pk,nome,login,senha) VALUES(?,?,?,?)";
                    statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    statement.setInt(1, (int)key);
                    statement.setString(2, funcionario.getNome());
                    statement.setString(3, funcionario.getLogin());
                    statement.setString(4, funcionario.getSenha());
                    resultado = statement.execute();
                }
                else{
                    sql = "INSERT INTO atendente(pk,nome,login,senha) VALUES(?,?,?,?)";
                    statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    statement.setInt(1, (int)key);
                    statement.setString(2, funcionario.getNome());
                    statement.setString(3, funcionario.getLogin());
                    statement.setString(4, funcionario.getSenha());
                    resultado = statement.execute(); 
                }
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOconcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }

    @Override
    public ArrayList<Funcionario> readFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario readFuncionarioById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario readFuncionarioByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateFuncionario(int id, Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
