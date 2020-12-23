package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTruckSplit;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestAnalyzeTruckSplit extends Request<AnalyzeTruckSplit> {
    @Override
    public void insert(AnalyzeTruckSplit analyzeTruckSplit) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_analyzeTrucksplit` (`fkLabSplit`) VALUES (?);";
            prepareStatement(sql);
            stmt.setLong(1, analyzeTruckSplit.getLabSplit().getIdSplit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<AnalyzeTruckSplit> select() {
        return null;
    }

    @Override
    public List<AnalyzeTruckSplit> select(List<String> clause, AnalyzeTruckSplit analyzeTruckSplit) {
        return null;
    }
}
