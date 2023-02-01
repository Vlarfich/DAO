package DAO.javaSQL;

import DAO.DAO;
import hierarchy.ProjectManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerDAO implements DAO<Integer, ProjectManager> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM ProjectManager";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM ProjectManager WHERE id=?";

    @Override
    public List<ProjectManager> read() {
        List<ProjectManager> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
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
    public ProjectManager read(Integer id) {
        ProjectManager user = null;
        try (Connection connection = ConnectionPool.getConnection();
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
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM ProjectManager WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(ProjectManager entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(ProjectManager entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO ProjectManager VALUES (" + entity.simpleString() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }
    @Override
    public ProjectManager update(ProjectManager entity) {
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE ProjectManager SET name = \"" + entity.getName() + "\" WHERE id = " + entity.getId();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return entity;
    }
}