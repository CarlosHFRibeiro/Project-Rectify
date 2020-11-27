package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Driver;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestDriver extends Request<Driver> {

    private List<Driver> drivers;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_driver";
    private String where = "";

    @Override
    public void insert(Driver driver) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_driver` (`cnhDriver`, `nameDriver`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setString(1, driver.getCnhDriver());
            stmt.setString(2, driver.getNameDriver());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage(), driver.getNameDriver());
        } finally {
            closeConnection();
        }
    }


    @Override
    public List<Driver> select() {
        return null;
    }

    @Override
    public List<Driver> select(Driver driver) {
        return null;
    }

    public Driver selectCnh(String driver) {
        SELECT_QUERY += " WHERE cnhDriver = ?";
        return selectAll(SELECT_QUERY, driver);
    }


    @Override
    public List<Driver> select(List<String> query, Driver parameter) {
        return null;
    }

    private Driver selectAll(String query, String parameter) {
        connection();
        try {
            prepareStatement(query);
            stmt.setString(1, parameter);
            resultSet();
            if (rs.next()) {
                Driver driver = new Driver();
                driver.setNameDriver(rs.getString("nameDriver"));
                driver.setCnhDriver(rs.getString("cnhDriver"));
                driver.setIdDriver(rs.getLong("idDriver"));
                return driver;
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return null;
    }
}
