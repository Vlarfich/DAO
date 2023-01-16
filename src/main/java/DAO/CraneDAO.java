package DAO;

import DAO.DAO;
import Hierarchy.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CraneDAO implements DAO<Integer, Crane> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Cranes";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Cranes WHERE id=?";

    @Override
    public List<Crane> findAll() {
        List<Crane> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                int height = rs.getInt(3);
                int Supplier_id = rs.getInt(4);
                int Projects_id = rs.getInt(5);
                users.add(new Crane(id, model, height, Supplier_id, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Crane findEntityById(Integer id) {
        Crane user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String model = rs.getString(2);
                int height = rs.getInt(3);
                int Supplier_id = rs.getInt(4);
                int Projects_id = rs.getInt(5);
                user = new Crane(id, model, height, Supplier_id, Projects_id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Crane entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Crane entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Crane update(Crane entity) {
        throw new UnsupportedOperationException();
    }
}