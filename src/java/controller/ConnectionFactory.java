/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vl
 */
public class ConnectionFactory {

    static Connection connections;

    public static java.sql.Connection getConnection() {
        if (connections == null) {
            return createConnection();
        } else {
            return connections;
        }
    }

    public static void setCommit(boolean commit) throws SQLException, Exception {
        getConnection().setAutoCommit(commit);
    }

    private static Connection createConnection() {
        String FILE_PROPERTY_NAME = "/utils/database.properties";
        Properties properties = new Properties();
        try {
            InputStream in = Class.class.getResourceAsStream(FILE_PROPERTY_NAME);
            properties.load(in);
            String driverName = properties.getProperty("database.driverName");
            String userName = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");
            String connectionString = properties.getProperty("database.url");
            Locale locale = Locale.getDefault();
            Locale.setDefault(Locale.ENGLISH);
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection(connectionString, userName, password);

            return connection;

        } catch (SQLException ex) {
            System.out.println("Not connection!!! ");
            return null;
        } catch (IOException ex) {
            System.out.println("Wrong prop. files!!! ");
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Bad driver file");
            return null;
        }

    }
}
