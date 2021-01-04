package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;
import dev.senzalla.rectify.treatments.QueryTreatment;

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
        try {
            super.connection();
            final String selectQuery = "INSERT INTO `tbl_tank` (`capacityTank`, `nameTank`) VALUES (?, ?);";
            super.prepareStatement(selectQuery);
            stmt.setInt(1, tank.getCapacityTank());
            stmt.setString(2, tank.getNameTank());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Tank" + ex.getMessage(), tank.getNameTank());
        } finally {
            super.closeConnection();
        }
    }

    public List<Tank> select() {
        List<Tank> tanks = new ArrayList<>();
        try {
            super.connection();
            final String SELECT_QUERY = QueryTreatment.createQuery("tbl_tank", null);
            super.prepareStatement(SELECT_QUERY);
            super.resultSet();
            while (rs.next()) {
                Tank tank = new Tank();
                tank.setIdTank(rs.getLong("idTank"));
                tank.setNameTank(rs.getString("nameTank"));
                tank.setCapacityTank(rs.getInt("capacityTank"));
                tanks.add(tank);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Tank" + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return tanks;
    }
}
