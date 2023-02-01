package DAO.javaSQL;

import DAO.DAO;
import hierarchy.MaterialSupplyCompany;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialSupplyCompanyDAO implements DAO<Integer, MaterialSupplyCompany> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM MaterialSupplyCompany";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM MaterialSupplyCompany WHERE id=?";

    @Override
    public List<MaterialSupplyCompany> read() {
        List<MaterialSupplyCompany> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);;
                String email = rs.getString(4);
                int Buildings_id = rs.getInt(5);
                int Projects_id = rs.getInt(6);
                users.add(new MaterialSupplyCompany(id, name, phone, email, Buildings_id, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public MaterialSupplyCompany read(Integer id) {
        MaterialSupplyCompany user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String phone = rs.getString(3);;
                String email = rs.getString(4);
                int Buildings_id = rs.getInt(5);
                int Projects_id = rs.getInt(6);
                user = new MaterialSupplyCompany(id, name, phone, email, Buildings_id, Projects_id);
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
            String sql = "DELETE FROM MaterialSupplyCompany WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(MaterialSupplyCompany entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(MaterialSupplyCompany entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO MaterialSupplyCompany VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ignored){

        }
        return true;
    }
    @Override
    public MaterialSupplyCompany update(MaterialSupplyCompany entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE MaterialSupplyCompany SET name = \"" + entity.getName() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){
        }
        return entity;
    }
}