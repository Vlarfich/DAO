package DAO;

import Hierarchy.ConcreteMixer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMixerDAO implements DAO<Integer, ConcreteMixer> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM ConcreteMixers";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM ConcreteMixers WHERE id=?";

    @Override
    public List<ConcreteMixer> findAll() {
        List<ConcreteMixer> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                int volume = rs.getInt(3);
                int Supplier_id = rs.getInt(4);
                int Projects_id = rs.getInt(5);
                users.add(new ConcreteMixer(id, model, volume, Supplier_id, Projects_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public ConcreteMixer findEntityById(Integer id) {
        ConcreteMixer user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String model = rs.getString(2);
                int volume = rs.getInt(3);
                int Supplier_id = rs.getInt(4);
                int Projects_id = rs.getInt(5);
                user = new ConcreteMixer(id, model, volume, Supplier_id, Projects_id);
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
    public boolean delete(ConcreteMixer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(ConcreteMixer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ConcreteMixer update(ConcreteMixer entity) {
        throw new UnsupportedOperationException();
    }
}