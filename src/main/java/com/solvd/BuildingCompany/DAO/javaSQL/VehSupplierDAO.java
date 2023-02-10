package com.solvd.BuildingCompany.DAO.javaSQL;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.hierarchy.ProjectManager;
import com.solvd.BuildingCompany.hierarchy.VehSupplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehSupplierDAO implements DAO<Integer, VehSupplier> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM VehSuppliers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM VehSuppliers WHERE id=?";

    @Override
    public List<VehSupplier> read() {
        List<VehSupplier> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Buildings_id = rs.getInt(4);
                VehSupplier b = VehSupplier.builder()
                        .setId(id)
                        .setName(name)
                        .setBuildingsId(Buildings_id)
                        .build();
                users.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public VehSupplier read(Integer id) {
        VehSupplier user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int Buildings_id = rs.getInt(3);
                VehSupplier b = VehSupplier.builder()
                        .setId(id)
                        .setName(name)
                        .setBuildingsId(Buildings_id)
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
            String sql = "DELETE FROM VehSuppliers WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(VehSupplier entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(VehSupplier entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO VehSuppliers VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }
    @Override
    public VehSupplier update(VehSupplier entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE VehSupplier SET name = \"" + entity.getName() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){
        }
        return entity;
    }
}