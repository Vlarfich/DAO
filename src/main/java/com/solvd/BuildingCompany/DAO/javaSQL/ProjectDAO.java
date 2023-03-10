package com.solvd.BuildingCompany.DAO.javaSQL;

import com.solvd.BuildingCompany.DAO.DAO;
import com.solvd.BuildingCompany.hierarchy.Building;
import com.solvd.BuildingCompany.hierarchy.Project;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProjectDAO implements DAO<Integer, Project> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Projects";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Projects WHERE id=?";

    @Override
    public List<Project> read() {
        List<Project> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Project b = Project.builder()
                        .setId(id)
                        .setName(name)
                        .build();
                users.add(b);
            }
        } catch (SQLException e) {
            LogManager.getLogger(ProjectDAO.class).warn(e.getMessage());
        }
        return users;
    }

    @Override
    public Project read(Integer id) {
        Project user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                Project b = Project.builder()
                        .setId(id)
                        .setName(name)
                        .build();
                user = b;
            }
        } catch (SQLException e) {
            LogManager.getLogger(ProjectDAO.class).warn(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM Projects WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        } catch (SQLException sqlException) {
            LogManager.getLogger(ProjectDAO.class).warn(sqlException.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Project entity) {
        return delete(entity.getId());
    }

    @Override
    public boolean create(Project entity) {
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO Projects VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException sqlException) {
            LogManager.getLogger(ProjectDAO.class).warn(sqlException.getMessage());
        }
        return true;
    }

    @Override
    public Project update(Project entity) {
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "UPDATE Projects SET name = \"" + entity.getName() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        } catch (SQLException sqlException) {
            LogManager.getLogger(ProjectDAO.class).warn(sqlException.getMessage());
        }
        return entity;
    }
}