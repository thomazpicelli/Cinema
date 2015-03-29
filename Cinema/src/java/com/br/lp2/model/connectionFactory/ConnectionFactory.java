package com.br.lp2.model.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thomazpicelli
 */
public class ConnectionFactory {
    public static final String driver = "org.apache.derby.jdbc.ClientDriver";
    public static final String protocol = "jdbc:derby:";
    public static final String dbname = "cinema_db";
    private static final String dominio = "//localhost:1527/"; 
    private Connection connection;

    public ConnectionFactory() {
    }
    
    public Connection getConnection(String tipo){
        if(tipo.equalsIgnoreCase("derby")){
            try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(protocol+dominio+dbname,"mack","mack");
        } catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            ex.getMessage();
        }
        }
        return connection;
    }
}