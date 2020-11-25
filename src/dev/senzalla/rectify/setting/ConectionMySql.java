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
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;

    public static void connection(){
        connection = ConnectionMySql.getConnection();
    }

    public static void prepareStatement(String sql) throws SQLException {
        stmt = connection.prepareStatement(sql);
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
