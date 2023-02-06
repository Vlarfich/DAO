package com.solvd.BuildingCompany.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        try (InputStream input = ConnectorDB.class.getClassLoader().getResourceAsStream("db.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.password");
            String dbName = prop.getProperty("db.name");

            return DriverManager.getConnection(url + dbName, user, pass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}