package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.ElementDuplicate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TankRequest extends Request<Tank> {

    private List<Tank> tanks;
    private final String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_tank;";

    @Override
    public void insert(Tank tank) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_tank` (`capacityTank`, `nameTank`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, tank.getCapacityTank());
            stmt.setString(2, tank.getNameTank());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new ElementDuplicate().processMsg(ex.getMessage(), tank.getNameTank());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Tank> select() {
        selectAll(SELECT_QUERY);
        return tanks;
    }

    @Override
    public List<Tank> select(Tank tank) {
        return null;
    }

    @Override
    public List<Tank> select(Map<String, Tank> clause) {
        return null;
    }

    private void selectAll(String select) {
        connection();
        if (tanks == null) {
            tanks = new ArrayList<>();
        }
        try {
            prepareStatement(select);
            resultSet();
            while (rs.next()) {
                Tank tank = new Tank();
                tank.setIdTank(rs.getLong("idTank"));
                tank.setNameTank(rs.getString("nameTank"));
                tank.setCapacityTank(rs.getInt("capacityTank"));
                tanks.add(tank);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
