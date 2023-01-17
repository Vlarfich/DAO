package DAO;

import DAO.DAO;
import Hierarchy.Customer;
import Hierarchy.VehSupplier;
import Hierarchy.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO implements DAO<Integer, Worker> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Workers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Workers WHERE id=?";

    @Override
    public List<Worker> findAll() {
        List<Worker> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                users.add(new Worker(id, name, age, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Worker findEntityById(Integer id) {
        Worker user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                user = new Worker(id, name, age, Projects_id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection conn = ConnectorDB.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM Workers WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(Worker entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(Worker entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Worker update(Worker entity) {
        throw new UnsupportedOperationException();
    }
}