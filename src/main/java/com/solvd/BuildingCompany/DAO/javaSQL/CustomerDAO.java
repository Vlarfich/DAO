package com.solvd.BuildingCompany.DAO.javaSQL;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.hierarchy.Crane;
import com.solvd.BuildingCompany.hierarchy.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Integer, Customer> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Customers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Customers WHERE id=?";

    @Override
    public List<Customer> read() {
        List<Customer> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);;
                String email = rs.getString(4);;
                int Projects_id = rs.getInt(5);
                Customer b = Customer.builder()
                        .setId(id)
                        .setName(name)
                        .setPhone(phone)
                        .setEmail(email)
                        .setProjectsId(Projects_id)
                        .build();
                users.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Customer read(Integer id) {
        Customer user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String phone = rs.getString(3);;
                String email = rs.getString(4);;
                int Projects_id = rs.getInt(5);
                Customer b = Customer.builder()
                        .setId(id)
                        .setName(name)
                        .setPhone(phone)
                        .setEmail(email)
                        .setProjectsId(Projects_id)
                        .build();
                user = b;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM Customers WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(Customer entity) {
        return delete(entity.getId());
    }

    @Override
    public boolean create(Customer entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Customers VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public Customer update(Customer entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE Customers SET email = \"" + entity.getEmail() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return entity;
    }
}