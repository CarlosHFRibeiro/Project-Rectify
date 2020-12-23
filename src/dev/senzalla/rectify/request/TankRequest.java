package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TankRequest extends ConectionMySql {

    public void insert(Tank tank) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_tank` (`capacityTank`, `nameTank`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, tank.getCapacityTank());
            stmt.setString(2, tank.getNameTank());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.processMsg("Tanque" + ex.getMessage(), tank.getNameTank());
        } finally {
            closeConnection();
        }
    }


    public List<Tank> select() {
        List<Tank> tanks = new ArrayList<>();
        try {
            connection();
            final String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_tank";
            prepareStatement(SELECT_QUERY);
            resultSet();
            while (rs.next()) {
                Tank tank = new Tank();
                tank.setIdTank(rs.getLong("idTank"));
                tank.setNameTank(rs.getString("nameTank"));
                tank.setCapacityTank(rs.getInt("capacityTank"));
                tanks.add(tank);
            }
        } catch (SQLException ex) {
            DataBaseException.processMsg("Tanque" + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return tanks;
    }

}
