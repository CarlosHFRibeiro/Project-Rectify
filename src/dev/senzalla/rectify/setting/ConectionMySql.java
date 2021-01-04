package dev.senzalla.rectify.setting;

import dev.senzalla.connector.ConnectionMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ConectionMySql {

    private static Connection connection = null;
    protected static PreparedStatement stmt = null;
    protected static ResultSet rs = null;

    protected void connection() {
        connection = ConnectionMySql.getConnection();
    }

    protected void prepareStatement(String sql) throws SQLException {
        stmt = connection.prepareStatement(sql);
    }

    protected void resultSet() throws SQLException {
        rs = stmt.executeQuery();
    }

    protected void closeConnection() {
        ConnectionMySql.closeConnection(connection, stmt);
    }

    protected void closeConnectionRs() {
        ConnectionMySql.closeConnection(connection, stmt, rs);
    }
}
