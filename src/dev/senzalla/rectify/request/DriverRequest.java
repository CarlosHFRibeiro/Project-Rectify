package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Driver;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class DriverRequest extends ConectionMySql {

    public void insert(Driver driver) {
        super.connection();
        try {
            final String sql = "INSERT INTO `tbl_driver` (`cnhDriver`, `nameDriver`) VALUES (?, ?);";
            super.prepareStatement(sql);
            stmt.setString(1, driver.getCnhDriver());
            stmt.setString(2, driver.getNameDriver());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Driver: " + ex.getMessage(), driver.getNameDriver());
        } finally {
            super.closeConnection();
        }
    }

    public Driver selectCnh(String parameter) {
        Driver driver = null;
        try {
            final String SELECT_QUERY = "SELECT * FROM tbl_driver WHERE cnhDriver = ?";
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            stmt.setString(1, parameter);
            super.resultSet();
            if (rs.next()) {
                driver = new Driver();
                driver.setNameDriver(rs.getString("nameDriver"));
                driver.setCnhDriver(rs.getString("cnhDriver"));
                driver.setIdDriver(rs.getLong("idDriver"));
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Driver: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return driver;
    }
}
