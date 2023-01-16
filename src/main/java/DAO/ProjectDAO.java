package DAO;

import DAO.DAO;
import Hierarchy.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements DAO<Integer, Project> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Projects";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Projects WHERE id=?";

    @Override
    public List<Project> findAll() {
        List<Project> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                users.add(new Project(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Project findEntityById(Integer id) {
        Project user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                user = new Project(id, name);
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
    public boolean delete(Project entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Project entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Project update(Project entity) {
        throw new UnsupportedOperationException();
    }
}