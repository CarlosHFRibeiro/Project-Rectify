package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabSplit;
import dev.senzalla.rectify.exception.ElementDuplicate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class LabSplitRequest extends Request<LabSplit> {

    private List<LabSplit> labSplits;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_labsplit";
    private String where = " ORDER BY idSplit DESC";

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
            System.out.println(stmt);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            new ElementDuplicate().processMsg(ex.getMessage(), null);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<LabSplit> select() {
        selectAll(SELECT_QUERY + where, null);
        return labSplits;
    }

    @Override
    public List<LabSplit> select(LabSplit labSplit) {
        return null;
    }

    @Override
    public List<LabSplit> select(List<String> clause, LabSplit labSplit) {
        return null;
    }

    private void selectAll(String select, LabSplit clause) {
        connection();
        labSplits = new ArrayList<>();
        try {
            prepareStatement(select);
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnectionRs();
        }
    }
}
