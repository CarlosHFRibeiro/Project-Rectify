package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTruckSplit;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTruckSplitRequest extends ConectionMySql {
    public void insert(AnalyzeTruckSplit analyzeTruckSplit) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_analyzeTrucksplit` (`fkAnalyzeSplit`) VALUES (?);";
            prepareStatement(sql);
            stmt.setLong(1, analyzeTruckSplit.getAnalyzeSplit().getIdAnalyzeSplit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Truck Split: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }
}
