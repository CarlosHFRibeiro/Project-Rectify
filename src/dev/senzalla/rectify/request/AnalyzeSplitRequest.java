package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeSplit;
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
public class AnalyzeSplitRequest extends ConectionMySql {

    public void insert(AnalyzeSplit analyzeSplit) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_analyze_split` (`fattyAcidPercentSplit`, `sludgePercentSplit`, `glycerinPercentSplit`, `trashPercentSplit`) VALUES (?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, analyzeSplit.getFattyAcidPercentSplit());
            stmt.setDouble(2, analyzeSplit.getSludgePercentSplit());
            stmt.setDouble(3, analyzeSplit.getGlycerinPercentSplit());
            stmt.setDouble(4, analyzeSplit.getTrashPercentSplit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase(ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }


    public List<AnalyzeSplit> select() {
        String SELECT_QUERY = "SELECT * FROM tbl_analyze_split ORDER BY idAnalyzeSplit DESC";
        return selectAll(SELECT_QUERY, null);
    }


    public List<AnalyzeSplit> select(List<String> query, AnalyzeSplit analyzeSplit) {
        String SELECT_QUERY = QueryTreatment.createQuery("tbl_analyze_split", query);
        return selectAll(SELECT_QUERY, analyzeSplit);
    }

    private List<AnalyzeSplit> selectAll(String select, AnalyzeSplit parameter) {
        List<AnalyzeSplit> analyzeSplits = new ArrayList<>();
        try {
            super.connection();
            super.prepareStatement(select);
            prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                AnalyzeSplit analyzeSplit = new AnalyzeSplit();
                analyzeSplit.setIdAnalyzeSplit(rs.getLong("idAnalyzeSplit"));
                analyzeSplit.setFattyAcidPercentSplit(rs.getDouble("fattyAcidPercentSplit"));
                analyzeSplit.setSludgePercentSplit(rs.getDouble("sludgePercentSplit"));
                analyzeSplit.setGlycerinPercentSplit(rs.getDouble("glycerinPercentSplit"));
                analyzeSplit.setTrashPercentSplit(rs.getDouble("trashPercentSplit"));
                analyzeSplit.setDateAnalyzeSplit(rs.getDate("dateAnalyzeSplit"));
                analyzeSplit.setTimeAnalyzeSplit(rs.getTime("timeAnalyzeSplit"));
                analyzeSplits.add(analyzeSplit);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase(ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return analyzeSplits;
    }

    private void prepareStatement(AnalyzeSplit parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdAnalyzeSplit() != null) {
                stmt.setLong(i++, parameter.getIdAnalyzeSplit());
            }
            if (parameter.getDateAnalyzeSplit() != null) {
                stmt.setDate(i++, parameter.getDateAnalyzeSplit());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i, parameter.getDateBetween());
            }
        }
    }
}
