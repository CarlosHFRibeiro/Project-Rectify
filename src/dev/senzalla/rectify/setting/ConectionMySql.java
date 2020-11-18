package dev.senzalla.rectify.setting;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import dev.senzalla.connector.ConnectionMySql;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ConectionMySql {

    private static final Connection connection = ConnectionMySql.getConnection();
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;

    public static Connection connection() {
        return connection;
    }

    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        stmt = connection.prepareStatement(sql);
        return stmt;
    }

    public static void resultSet() throws SQLException {
        rs = stmt.executeQuery();
    }

    public static void closeConnection() {
        ConnectionMySql.closeConnection(connection, stmt);
    }

    public static void closeConnectionRs() {
        ConnectionMySql.closeConnection(connection, stmt, rs);
    }
}
