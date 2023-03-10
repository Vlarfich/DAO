package com.solvd.BuildingCompany.DAO.javaSQL;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.hierarchy.ProjectManager;
import com.solvd.BuildingCompany.hierarchy.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO implements DAO<Integer, Worker> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Workers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Workers WHERE id=?";

    @Override
    public List<Worker> read() {
        List<Worker> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                Worker b = Worker.builder()
                        .setId(id)
                        .setName(name)
                        .setAge(age)
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
    public Worker read(Integer id) {
        Worker user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                Worker b = Worker.builder()
                        .setId(id)
                        .setName(name)
                        .setAge(age)
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
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Workers VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }
    @Override
    public Worker update(Worker entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE Workers SET Projects_id = \"" + entity.getProjects_id() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return entity;
    }
}