package com.solvd.BuildingCompany.DAO.javaSQL;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.hierarchy.Bulldozer;
import com.solvd.BuildingCompany.hierarchy.ConcreteMixer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMixerDAO implements DAO<Integer, ConcreteMixer> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM ConcreteMixers";
    public static final String SQL_SELECT_USER_ID = "SELECT * FROM ConcreteMixers WHERE id=?";

    @Override
    public List<ConcreteMixer> read() {
        List<ConcreteMixer> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);

            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                int volume = rs.getInt(3);
                int Supplier_id = rs.getInt(4);
                int Projects_id = rs.getInt(5);
                ConcreteMixer b = ConcreteMixer.builder()
                        .setId(id)
                        .setModel(model)
                        .setVolume(volume)
                        .setSupplierId(Supplier_id)
                        .setProjectsId(Projects_id)
                        .build();
                users.add(b);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    @Override
    public ConcreteMixer read(Integer id) {
        ConcreteMixer user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String model = rs.getString(2);
                int volume = rs.getInt(3);
                int Supplier_id = rs.getInt(4);
                int Projects_id = rs.getInt(5);
                ConcreteMixer b = ConcreteMixer.builder()
                        .setId(id)
                        .setModel(model)
                        .setVolume(volume)
                        .setSupplierId(Supplier_id)
                        .setProjectsId(Projects_id)
                        .build();
                user = b;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM ConcreteMixers WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){
            System.err.println(sqlException.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(ConcreteMixer entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(ConcreteMixer entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO ConcreteMixers VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }
    @Override
    public ConcreteMixer update(ConcreteMixer entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE ConcreteMixers SET model = \"" + entity.getModel() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return entity;
    }
}