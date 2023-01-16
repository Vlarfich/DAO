package DAO;

import DAO.DAO;
import Hierarchy.Customer;
import Hierarchy.VehSupplier;
import Hierarchy.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehSupplierDAO implements DAO<Integer, VehSupplier> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM VehSuppliers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM VehSuppliers WHERE id=?";

    @Override
    public List<VehSupplier> findAll() {
        List<VehSupplier> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Buildings_id = rs.getInt(4);
                users.add(new VehSupplier(id, name, Buildings_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public VehSupplier findEntityById(Integer id) {
        VehSupplier user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Buildings_id = rs.getInt(4);
                user = new VehSupplier(id, name, Buildings_id);
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
    public boolean delete(VehSupplier entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(VehSupplier entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public VehSupplier update(VehSupplier entity) {
        throw new UnsupportedOperationException();
    }
}