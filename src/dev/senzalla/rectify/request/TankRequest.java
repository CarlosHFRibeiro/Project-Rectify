package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Tank;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class TankRequest extends Request<Tank> {
    

    @Override
    public void insert(Tank tank) {
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_tank` (`capacityTank`, `nameTank`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, tank.getCapacityTank());
            stmt.setString(2, tank.getNameTank());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Tank> select(Tank tank) {
        return null;
    }

    @Override
    public List<Tank> select(Map<String, String> clause, Tank tank) {
        return null;
    }
}
