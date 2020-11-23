package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabTank;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.ElementDuplicate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class LabTankRequest extends Request<LabTank> {

    private List<LabTank> labtanks;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_labtank";
    private String where = "";

    @Override
    public void insert(LabTank labtank) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_labtank` " +
                    "(`trashTq`, `fkTankTq`, `acidTq`, `soapTq`) VALUES (?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, labtank.getTrashTq());
            stmt.setLong(2, labtank.getTank().getIdTank());
            stmt.setDouble(3, labtank.getAcidTq());
            stmt.setDouble(4, labtank.getSoapTq());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new ElementDuplicate().processMsg(ex.getMessage(), null);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<LabTank> select() {
        selectAll(SELECT_QUERY, null);
        return labtanks;
    }

    @Override
    public List<LabTank> select(LabTank labtank) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List<LabTank> select(List<String> query, LabTank labTank) {
        query.forEach(s -> where += String.format(" %s ? AND", s));

        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, null);
        return labtanks;
    }

    private void selectAll(String query, LabTank labTank) {
        connection();
        if (labtanks == null) {
            labtanks = new ArrayList<>();
        }
        try {
            prepareStatement(query);
            if (labTank != null) {
                stmt.setLong(1, labTank.getIdTq());
                stmt.setString(2, labTank.getTank().getNameTank());
                stmt.setTimestamp(3, labTank.getDtTq());
                stmt.setDate(4, labTank.getDateBetween());
            }
            resultSet();
            while (rs.next()) {
                LabTank labtank = new LabTank();
                labtank.setIdTq(rs.getLong("idTq"));
                labtank.setTrashTq(rs.getInt("trashTq"));
                labtank.setAcidTq(rs.getDouble("acidTq"));
                labtank.setSoapTq(rs.getDouble("soapTq"));
                labTank.setDtTq(rs.getTimestamp("dtTq"));

                Tank tank = new Tank();
                tank.setNameTank(rs.getString("nameTank"));
                labTank.setTank(tank);

                labtanks.add(labtank);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
