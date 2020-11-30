package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabSplit;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestLabSplit extends Request<LabSplit> {

    private List<LabSplit> labSplits;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_labsplit";
    private String where = " ";
    private final String ORDER = " ORDER BY idSplit DESC";

    @Override
    public void insert(LabSplit labSplit) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_labsplit` (`oilSplit`, `sludgeSplit`, `glycerinSplit`, `trashSplit`) VALUES (?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, labSplit.getOilSplit());
            stmt.setInt(2, labSplit.getSludgeSplit());
            stmt.setInt(3, labSplit.getGlycerinSplit());
            stmt.setInt(4, labSplit.getTrashSplit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<LabSplit> select() {
        selectAll(SELECT_QUERY + ORDER, null);
        return labSplits;
    }

    @Override
    public List<LabSplit> select(List<String> query, LabSplit labSplit) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY + ORDER, labSplit);
        return labSplits;
    }

    private void selectAll(String select, LabSplit parameter) {
        connection();
        labSplits = new ArrayList<>();
        try {
            prepareStatement(select);
            if (parameter != null) {
                int i = 1;
                if (parameter.getIdSplit() != null) {
                    stmt.setLong(i++, parameter.getIdSplit());
                }
                if (parameter.getDtSplit() != null) {
                    stmt.setDate(i++, parameter.getDtSplit());
                }
                if (parameter.getDateBetween() != null) {
                    stmt.setDate(i, parameter.getDateBetween());
                }
            }
            resultSet();
            while (rs.next()) {
                LabSplit labSplit = new LabSplit();
                labSplit.setIdSplit(rs.getLong("idSplit"));
                labSplit.setOilSplit(rs.getInt("oilSplit"));
                labSplit.setSludgeSplit(rs.getInt("sludgeSplit"));
                labSplit.setGlycerinSplit(rs.getInt("glycerinSplit"));
                labSplit.setTrashSplit(rs.getInt("trashSplit"));
                labSplit.setDtSplit(rs.getDate("dtSplit"));
                labSplit.setHrSplit(rs.getTime("hrSplit"));
                labSplits.add(labSplit);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
