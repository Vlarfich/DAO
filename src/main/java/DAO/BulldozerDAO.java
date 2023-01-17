package DAO;

import Hierarchy.Bulldozer;
import Hierarchy.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BulldozerDAO implements DAO<Integer, Bulldozer> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Buldozers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM Buldozers WHERE id=?";

    @Override
    public List<Bulldozer> findAll() {
        List<Bulldozer> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                int Supplier_id = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                users.add(new Bulldozer(id, model, Supplier_id, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Bulldozer findEntityById(Integer id) {
        Bulldozer user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                int Projects_id = rs.getInt(4);
                user = new Bulldozer(id, name, age, Projects_id);
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
            String sql = "DELETE FROM Buldozers WHERE id = " + id.toString();
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlException){

        }
        return true;
    }

    @Override
    public boolean delete(Bulldozer entity) {
        return delete(entity.getId());
    }
    @Override
    public boolean create(Bulldozer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bulldozer update(Bulldozer entity) {
        throw new UnsupportedOperationException();
    }
}