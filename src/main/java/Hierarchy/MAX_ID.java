package Hierarchy;

import DAO.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MAX_ID {

    public static int getMAX_ID(String tableName){
        Building user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("SELECT MAX(id) FROM " + tableName)) {

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}
