package DAO.javaSQL;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        try (InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.password");
            String dbName = prop.getProperty("db.name");

            ds.setUrl(url + dbName);
            ds.setUsername(user);
            ds.setPassword(pass);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private ConnectionPool() {
    }
}