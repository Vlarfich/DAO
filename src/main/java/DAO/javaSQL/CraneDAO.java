package DAO.javaSQL;

import DAO.DAO;
import hierarchy.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CraneDAO implements DAO<Integer, Crane> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Cranes";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Cranes WHERE id=?";

    @Override
    public List<Crane> read() {
        List<Crane> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
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
    public Crane read(Integer id) {
        Crane user = null;
        try (Connection connection = ConnectionPool.getConnection();
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
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM Cranes WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(Crane entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(Crane entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Cranes VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }
    @Override
    public Crane update(Crane entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE Cranes SET model = \"" + entity.getModel() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return entity;
    }
}