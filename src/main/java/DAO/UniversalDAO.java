package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniversalDAO implements DAO<Integer,Object>{

    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Customers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Customers WHERE id=?";

    @Override
    public List<Object> findAll() {
        List<Object> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();
            while (rs.next()) {
                List<Object> l = new ArrayList<>();
                for(int i = 1; i <= size; i++){
                    Class c = SQLTypeMap.toClass(rsmd.getColumnType(i));

                    Object o = rs.getObject(i);
                    l.add(o);
                }
                users.add(l);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public List<Object> findEntityById(Integer id) {
        List<Object> user = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();
            if (rs.next()) {
                for(int i = 1; i <= size; i++){
                    Object o = rs.getObject(i);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Object entity) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }
}
