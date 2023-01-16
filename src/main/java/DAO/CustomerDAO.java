package DAO;

import DAO.DAO;
import Hierarchy.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Integer, Customer> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Customers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Customers WHERE id=?";

    @Override
    public List<Customer> findAll() {
        List<Customer> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);;
                String email = rs.getString(4);;
                int Projects_id = rs.getInt(5);
                users.add(new Customer(id, name, phone, email, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Customer findEntityById(Integer id) {
        Customer user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String phone = rs.getString(3);;
                String email = rs.getString(4);;
                int Projects_id = rs.getInt(5);
                user = new Customer(id, name, phone, email, Projects_id);
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
    public boolean delete(Customer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Customer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Customer update(Customer entity) {
        throw new UnsupportedOperationException();
    }
}