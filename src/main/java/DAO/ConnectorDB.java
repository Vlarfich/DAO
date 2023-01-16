package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://52.59.193.212:3306/";
        String user = "root";
        String pass = "devintern";
        String dbName = "BuildingCompany";

        return DriverManager.getConnection(url + dbName, user, pass);
    }
}