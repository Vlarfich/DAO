package DAO.javaSQL;

import DAO.DAO;
import hierarchy.Building;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingDAO implements DAO<Integer, Building> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Buildings";
    public static final String SQL_SELECT_USER_ID = "SELECT * FROM Buildings WHERE id=?";

    @Override
    public List<Building> read() {
        List<Building> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String address = rs.getString(2);
                users.add(new Building(id, address));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Building read(Integer id) {
        Building user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String adress = rs.getString(2);
                user = new Building(id, adress);
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
            String sql = "DELETE FROM Buildings WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(Building entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(Building entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Buildings VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public Building update(Building entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE Buildings SET adress = \"" + entity.getAddress() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return entity;
    }

}