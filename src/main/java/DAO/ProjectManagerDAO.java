package DAO;

import DAO.DAO;
import Hierarchy.Customer;
import Hierarchy.ProjectManager;
import Hierarchy.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerDAO implements DAO<Integer, ProjectManager> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM ProjectManager";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM ProjectManager WHERE id=?";

    @Override
    public List<ProjectManager> findAll() {
        List<ProjectManager> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                users.add(new ProjectManager(id, name, age, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public ProjectManager findEntityById(Integer id) {
        ProjectManager user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                user = new ProjectManager(id, name, age, Projects_id);
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
    public boolean delete(ProjectManager entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(ProjectManager entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProjectManager update(ProjectManager entity) {
        throw new UnsupportedOperationException();
    }
}